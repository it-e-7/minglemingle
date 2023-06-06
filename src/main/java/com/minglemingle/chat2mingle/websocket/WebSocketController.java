package com.minglemingle.chat2mingle.websocket;

import com.minglemingle.chat2mingle.auth.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chat")
public class WebSocketController {
    @GetMapping("")
    @Auth(status = Auth.AccountStatus.ALLOWED_TO_CHAT)
    public String chattingRoom(@RequestParam String nickname,
                               @RequestParam Integer channel,
                               @RequestParam Integer accountType,
                               Model model){
        model.addAttribute("nickname", nickname);
        model.addAttribute("channel", channel);
        model.addAttribute("accountType", accountType);
        return "message/chattingRoom";
    }
}
