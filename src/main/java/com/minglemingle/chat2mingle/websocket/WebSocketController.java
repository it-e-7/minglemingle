package com.minglemingle.chat2mingle.websocket;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import com.minglemingle.chat2mingle.util.JSPConst;
import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.websocket.service.WebSocketVisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/chat")
public class WebSocketController {
    public WebSocketController(WebSocketVisitorService webSocketVisitor) {
        this.webSocketVisitor = webSocketVisitor;
    }

    private final WebSocketVisitorService webSocketVisitor;
    @GetMapping("")
    @Auth(status = Auth.AccountStatus.NEED_PERMISSION_TO_CHAT)
    public String chattingRoom(@RequestParam Integer channel,
                               @SessionAttribute MemberVO member,
                               Model model){
        model.addAttribute("member", member);
        model.addAttribute("channel", channel);
        model.addAttribute("categorySubtitle", JSPConst.getCatagorySubtitleByChannel(channel));
        webSocketVisitor.updateVisitor(channel, member.getNickname());
        model.addAttribute("visitors", webSocketVisitor.selectAllVisitor(channel));
        return "message/chattingRoom";
    }
}
