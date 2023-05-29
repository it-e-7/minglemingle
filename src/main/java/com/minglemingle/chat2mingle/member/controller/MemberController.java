package com.minglemingle.chat2mingle.member.controller;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.auth.Auth;
import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/member")
//@SessionAttributes(value = {"member"})
public class MemberController {
    Logger log = LogManager.getLogger("case3");
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


    @ModelAttribute("member")
    public MemberVO setEmptyMember() {
        return new MemberVO();
    }

    @GetMapping(value = "signup")
    public String signupPageHandler() {
        return "member/signup";
    }

    @PostMapping(value = "signup")
    public String signupHandler(@ModelAttribute MemberVO member) {
        boolean result = service.registerMember(member);
        return "redirect:/member/login";
    }

    @GetMapping(value = "login")
    public String loginPageHandler(SessionStatus sessionStatus)
    {
        // redirect 됐을시 필요한 코드
        sessionStatus.setComplete();
        return "member/login";
    }

    @PostMapping(value = "processLogin")
    public String loginHandler(@SessionAttribute("member") MemberVO member,
                               Model model) {
//    public String loginHandler(@SessionAttribute("member") MemberVo member, @ModelAttribute(value ="member") MemberVO member) {
//        MemberVO resultMember = service.loginService(member);
//
//        if (resultMember ==null){
//            sessionStatus.setComplete();
//            return "dd";
//        }
//        else {
//            member.setMemberId(resultMember.getMemberId());
            model.addAttribute("member", member);
            // TODO: Product 리스트 페이지로 redirect
            return "member/login-check";
//        }
    }

    @GetMapping("test")
    @Auth
    public String test() {
        return "test";
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
