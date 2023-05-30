package com.minglemingle.chat2mingle.admin.controller;

import com.minglemingle.chat2mingle.admin.vo.NoticeDTO;
import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    Logger logger = LogManager.getLogger("case3");

    MessageService service;

    public AdminController(MessageService service) {
        this.service = service;
    }

    @GetMapping(value="notice")
    @Auth(role= Auth.Role.ADMIN)
    public String adminPageNotice() {

        return "admin/notice";
    }

    @PostMapping(value="sendNotice")
    @DebugLog
    public ResponseEntity<Boolean> postNoticeToChannels(@RequestBody NoticeDTO noticeDtO) {
        List<Integer> channels = noticeDtO.getChannels();
        String content = noticeDtO.getContent();
        List<MessageDTO> noticeMessageList = new ArrayList<>();
        for (int channel : channels) {
            MessageDTO newMessage = new MessageDTO(0, null, channel, content, 5, null);
            noticeMessageList.add(newMessage);
        }

        logger.debug("TOSEND ==== " + noticeMessageList);
//    service.sendMessage(List<MessageDTO> messageDTO)

        return ResponseEntity.ok(true);
    }

    @GetMapping(value="reporthistory")
    @Auth(role= Auth.Role.ADMIN)
    public String adminPageAllReport() {
        return "admin/report-list";
    }

    @GetMapping(value="reporthistory/detail/{messageId}")
    @Auth(role= Auth.Role.ADMIN)
    public String adminPageReportDetail(@PathVariable("messageId") int messageId,
                                        Model model) {
        MessageDTO messageDTO = new MessageDTO(messageId, null, 0, null, 0, null);
        MessageDTO result = service.getOneMessage(messageDTO);
        model.addAttribute("message", result);
        return "admin/report-detail";
    }

}
