package com.minglemingle.chat2mingle.member.controller;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/member")
@SessionAttributes(value = "member")
public class MemberController {

    public MemberController(MemberService service) {
        this.service = service;
    }

    private MemberService service;

//    @PostMapping(value = "/")
//    public String registerMemberHandler(@ModelAttribute(value = "login")
//                                        MemberVO member) {
//
//        boolean result = service.registerMember(member);
//        String viewName = "";
//
//        if(result) {
//            viewName = "/home";
//        } else {
//            viewName = "member/login";
//        }
//
//        return viewName;
//    }

    @GetMapping(value = "signup")
    public String signupPageHandler() {
        return "member/signup";
    }

    @PostMapping(value = "signup")
    public String signupHandler(@ModelAttribute MemberVO member) {
        boolean result = service.registerMember(member);
        return "member/signup";
    }

    @GetMapping(value = "login")
    public String loginPageHandler() {
        return "member/login";
    }

    @PostMapping(value = "login")
    public String loginHandler(@ModelAttribute MemberVO member, HttpSession session) {
        MemberVO resultMember = service.loginService(member);

        if (resultMember !=null){
            session.setAttribute("loggedInMember", resultMember);
            return "member/login-check";
        }
        return "dd";
    }
//    @ModelAttribute(value="loginMember")
//    public MemberVO createMember(MemberVO member) {
//        MemberVO mymember = service.loginService(member);
//        return "member/login";
//    }
//
//    @GetMapping(value = "info")
//    public String infoHandler(HttpServletRequest request){
//        HttpSession session = request.getSession(true);
//        boolean result = service.infoService(request);
//        return "member/info";
//    }
//
//    @PutMapping(value="/{memberId}")
//    public void editMemberHandelr(@ModelAttribute(value = "login")
//                                    @PathVariable(name="memberId"){
//        service.editMember(memberId);
//        return;
//    }

}
