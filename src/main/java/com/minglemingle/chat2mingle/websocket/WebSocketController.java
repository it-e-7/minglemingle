package com.minglemingle.chat2mingle.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chat")
public class WebSocketController {
    @GetMapping("/{id}")
    public String chattingRoom(@PathVariable String id, @RequestParam Integer channel, Model model){
        model.addAttribute("nickname", id);
        model.addAttribute("channel", channel);
        return "websocket/chattingRoom";
    }
}
