package com.minglemingle.chat2mingle.member.controller;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/member")
@SessionAttributes(value="login")
public class MemberController {

    public MemberController(MemberService service) {
        this.service = service;
    }
    private MemberService service;

    @GetMapping("signup")
    @DebugLog
    public String signupHandler(MemberVO member) {
        boolean result = service.registerMember(member);
        return "member/signup";
    }
/*
    @ModelAttribute(value="loginMember")
    public MemberVO createMember() {
        boolean result = service.loginService();
        return new MemberVO();
    }

    @GetMapping(value = "info")
    public String infoHandler(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        boolean result = service.infoService(request);
        return "member/info";
    }

    @PostMapping(value = "/")
    public String registerMemberHandler(@ModelAttribute(value = "login")
                                      MemberVO member) {

        boolean result = service.registerMember(member);
        String viewName = "";

        if(result) {
            viewName = "/home";
        } else {
            viewName = "member/login";
        }

        return viewName;
    }

    @PutMapping(value="/{memberId}")
    public void editMemberHandelr(@ModelAttribute(value = "login")
                                    @PathVariable(name="memberId"){
        service.editMember(memberId);
        return;
    }*/

}
