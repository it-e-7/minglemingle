package com.minglemingle.chat2mingle.home.controller;

import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    public HomeController() {
    }

    @RequestMapping(value = "")
    public String homeHandler () {
        return "home";
    }

    @RequestMapping(value = "test")
    public String TestHandler () {
        return "message/chattingListRoom";
    }

}
