package com.minglemingle.chat2mingle.admin.controller;

import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    MessageService service;

    public AdminController(MessageService service) {
        this.service = service;
    }

    @GetMapping(value="notice")
    @Auth(role= Auth.Role.ADMIN)
    public String adminPageNotice() {
        return "admin/notice";
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
