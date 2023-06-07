package com.minglemingle.chat2mingle.websocket;
import com.minglemingle.chat2mingle.util.JSPConst;
import lombok.extern.java.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.List;

import static com.minglemingle.chat2mingle.util.JSPConst.CATEGORY_TITLES;

@Controller
@RequestMapping("/chat")
public class WebSocketController {
    @GetMapping("")
    public String chattingRoom(@RequestParam String nickname,
                               @RequestParam Integer channel,
                               @RequestParam Integer accountType,
                               Model model){
        String key = JSPConst.keys.get(channel-1);
        String categorySubtitle = CATEGORY_TITLES.get(key);
        model.addAttribute("nickname", nickname);
        model.addAttribute("channel", channel);
        model.addAttribute("accountType", accountType);
        model.addAttribute("categorySubtitle", categorySubtitle);
        return "message/chattingRoom";
    }
}
