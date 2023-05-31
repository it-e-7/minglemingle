package com.minglemingle.chat2mingle.admin.controller;

import com.minglemingle.chat2mingle.admin.vo.NoticeDTO;
import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.kafka.producer.KafkaProducer;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    MessageService messageService;
    KafkaProducer producer;

    public AdminController(KafkaProducer producer, MessageService service) {
        this.producer = producer;
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
//      List<ReportDTO> reportList =   reportService.getReportList();
//        model.addAttrbiute("reportList", reportList);
        return "admin/report-list";
    }


    @GetMapping(value = "reporthistory/{messageId}")
    @Auth(role = Auth.Role.ADMIN)
    public String adminPageReportDetail(@PathVariable("messageId") int messageId,
                                        Model model) {
        MessageDTO messageDTO = new MessageDTO(messageId, null, 0, null, 0, null);
        MessageDTO reportDetail = messageService.getOneMessageByMessageId(messageDTO);
        model.addAttribute("reportList", reportDetail);
        return "admin/report-detail";
    }

}
