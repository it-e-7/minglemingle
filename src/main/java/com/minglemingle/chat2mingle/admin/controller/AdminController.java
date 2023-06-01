package com.minglemingle.chat2mingle.admin.controller;

import com.minglemingle.chat2mingle.admin.vo.NoticeDTO;
import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.kafka.producer.KafkaProducer;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import com.minglemingle.chat2mingle.report.service.ReportService;
import com.minglemingle.chat2mingle.report.vo.ReportVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    ReportService reportService;
    MessageService messageService;
    KafkaProducer producer;

    public AdminController(KafkaProducer producer, ReportService reportService, MessageService service) {
        this.producer = producer;
        this.reportService = reportService;
        this.messageService = service;
    }

    @GetMapping(value = "notice")
    @Auth(role = Auth.Role.ADMIN)
    public String adminPageNotice() {
        return "admin/notice";
    }

    @PostMapping(value = "sendNotice")
    @DebugLog
    @ResponseBody
    public ResponseEntity<Boolean> postNoticeToChannels(HttpServletRequest request, @RequestBody NoticeDTO noticeDtO) {
        HttpSession session = request.getSession();
        MemberVO sessionMember = (MemberVO) session.getAttribute("member");
        String adminNickname = sessionMember.getNickname();

        List<MessageDTO> noticeMessageList = new ArrayList<>();
        List<Integer> channels = noticeDtO.getChannels();
        String content = noticeDtO.getContent();

        for (int channel : channels) {
            MessageDTO newMessage = new MessageDTO(null, adminNickname, channel, content, 5, null);
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

        ReportVO reportVO = new ReportVO(timestamp, null, null, null, null, null, null);

        List<ReportVO> reportList = reportService.selectReportListByReportedDate(reportVO);

        model.addAttribute("reportList", reportList);
        return "admin/report-list";
    }


    @GetMapping(value = "reporthistory/{messageId}")
    @Auth(role = Auth.Role.ADMIN)
    public String adminPageReportDetail(@PathVariable("messageId") int messageId,
                                        Model model) {
        ReportVO reportVO = reportService.selectReportDetailByMessageId
        //        MessageDTO messageDTO = new MessageDTO(messageId, null, 0, null, 0, null);
//        MessageDTO reportDetail = messageService.getOneMessageByMessageId(messageDTO);
        model.addAttribute("reportDetail", reportDetail);
        return "admin/report-detail";
    }

    @ResponseBody
    @PostMapping("sendReport")
    public ResponseEntity<Boolean> processReportDetail(@RequestBody MultiValueMap<String, String> formData) {
//        ReportVO reportVO = reportService.g
        return ResponseEntity.ok(true);
    }

}
