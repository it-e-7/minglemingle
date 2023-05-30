package com.minglemingle.chat2mingle.member.controller;

import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/member")
//@SessionAttributes(value = {"member"})
public class MemberController {
    public MemberController(MemberService service) {
        this.service = service;
    }

    private MemberService service;

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
    public String loginPageHandler(HttpServletRequest request, Model model)
    {
        try {
            String loginMessage = (String) request.getSession(true).getAttribute("loginMessage");
            model.addAttribute("loginMessage", loginMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "member/login";
    }

    @PostMapping(value = "processLogin")
    public String loginHandler(@SessionAttribute("member") MemberVO member,
                               Model model) {
        model.addAttribute("member", member);
        return "product/home";
    }

    @GetMapping(value = "info")
    public String infoHandler(){
        return "member/info";
    }

    @PostMapping(value = "info")
    @ResponseBody
    public MemberVO infoEditHandler(HttpServletRequest request, @ModelAttribute(value ="member") MemberVO nicknameMember){
        HttpSession session = request.getSession();
        MemberVO sessionMember = (MemberVO) session.getAttribute("member");
        sessionMember.setNickname(nicknameMember.getNickname());
        service.infoEditService(sessionMember);
        return  sessionMember;
    }

    @PostMapping("logout")
    public String logoutHandler (SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "member/login";
    }


}
