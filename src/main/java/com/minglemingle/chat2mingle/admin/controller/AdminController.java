package com.minglemingle.chat2mingle.admin.controller;

import com.minglemingle.chat2mingle.admin.vo.NoticeDTO;
import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.kafka.producer.KafkaProducer;
import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import com.minglemingle.chat2mingle.report.service.ReportService;
import com.minglemingle.chat2mingle.report.vo.ReportDetailVO;
import com.minglemingle.chat2mingle.report.vo.ReportStatisticVO;
import com.minglemingle.chat2mingle.report.vo.ReportVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    ReportService reportService;
    MessageService messageService;
    MemberService memberService;
    KafkaProducer producer;

    public AdminController(KafkaProducer producer, MemberService memberService, ReportService reportService, MessageService service) {
        this.producer = producer;
        this.memberService = memberService;
        this.reportService = reportService;
        this.messageService = service;
    }

    @GetMapping(value = "notice")
    @Auth(role = Auth.Role.ADMIN)
    public String adminPageNotice() {
        return "admin/notice";
    }

    @PostMapping(value = "sendNotice")
    @ResponseBody
    public ResponseEntity<Boolean> postNoticeToChannels(HttpServletRequest request, @RequestBody NoticeDTO noticeDTO) {
        List<MessageDTO> noticeMessageList = new ArrayList<>();
        List<Integer> channels = noticeDTO.getChannels();
        String content = noticeDTO.getContent();

        for (int channel : channels) {
            MessageDTO newMessage = new MessageDTO(null, getAdminNickname(request), channel, content, 10, null);
            noticeMessageList.add(newMessage);
        }

        producer.sendMessage(noticeMessageList);

        return ResponseEntity.ok(true);
    }

    @GetMapping(value = "reporthistory")
    @Auth(role = Auth.Role.ADMIN)
    public String adminPageAllReport(Model model) {
        LocalDate currentDate = LocalDate.now();
        Timestamp timestamp = Timestamp.valueOf(currentDate.atStartOfDay());
        ReportVO reportVO = new ReportVO(timestamp, null, null, null, null, null, 0);

        List<ReportVO> reportList = reportService.selectReportListByReportedDate(reportVO);
        model.addAttribute("reportList", reportList);
        System.out.println(reportList);
        return "admin/report-list";
    }

    @GetMapping(value = "reportdetail")
    @Auth(role = Auth.Role.ADMIN)
    public String adminPageReportDetail(@RequestParam("messageId") int messageId,
                                        @RequestParam("memberId") String memberId,
                                        Model model) {
        ReportVO reportVO = new ReportVO(null, memberId, null, null, messageId, null, null);

        ReportDetailVO reportDetailVO = reportService.selectReportDetailByMessageId(reportVO);
        ReportStatisticVO reportStatisticVO = reportService.selectReportStatisticByMessageId(reportVO);
        model.addAttribute("reportDetail", reportDetailVO);
        model.addAttribute("reportStatistic", reportStatisticVO);
        return "admin/report-detail";
    }

    @PostMapping("sendReport")
    public String processReportDetail(
            HttpServletRequest request,
            ReportDetailVO reportDetailVO,
            @RequestBody MultiValueMap<String, String> formData
    ) {
        List<String> deleteMessageList = formData.get("delete-message");
        List<String> accountPunishmentList = formData.get("account-punishment");

        if (deleteMessageList != null) {
            MessageDTO messageDTO = new MessageDTO(reportDetailVO.getMessageId(), getAdminNickname(request), reportDetailVO.getChannel(), null, null, null);
            int result = messageService.updateMessageSent(messageDTO);
        }

        if (accountPunishmentList != null) {
            String suspendType = accountPunishmentList.get(0);
            MemberVO memberVO = new MemberVO(null, reportDetailVO.getReporteeNickname(), null, null, 0, null, 0);
            boolean result;
            switch (suspendType) {
                case "no-stop":
                case "chatting-stop":
                    memberVO.setAccountStatus(10);
                     result = memberService.changeAccountStatus(memberVO);
                case "login-stop":
                    memberVO.setAccountStatus(11);
                    result = memberService.changeAccountStatus(memberVO);
                default:
            }
        }

        ReportVO reportVO = new ReportVO(null, reportDetailVO.getMemberId(),null, null, reportDetailVO.getMessageId(), null, null);
        boolean result = reportService.setReportStatusDone(reportVO);

        return "redirect:/admin/reporthistory";
    }

    private String getAdminNickname(HttpServletRequest request){
        HttpSession session = request.getSession();
        MemberVO sessionMember = (MemberVO) session.getAttribute("member");
        String adminNickname = sessionMember.getNickname();
        return adminNickname;
    }

}
