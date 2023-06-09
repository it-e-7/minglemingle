package com.minglemingle.chat2mingle.member.controller;

import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/member")
//@SessionAttributes(value = {"member"})
public class MemberController {
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    private MemberService memberService;
    
    @ModelAttribute("member")
    public MemberVO setEmptyMember() {
        return new MemberVO();
    }

    @GetMapping(value = "signup")
    public String signupPageHandler() {
        return "member/signup";
    }

    @PostMapping(value = "signup")
    public String signupHandler(Model model, HttpServletRequest request, @ModelAttribute MemberVO member) {
        boolean result = memberService.registerMember(member);
        model.addAttribute("loginMessage", "signUpComplete");
        return "redirect:/member/login";
    }

    @GetMapping(value = "login")
    public String loginPageHandler(Model model,
                                   @RequestParam(value="loginMessage", required = false) String loginMessage) {
            model.addAttribute("loginMessage", loginMessage);
        return "member/login";
    }

    @PostMapping(value = "processLogin")
    public String loginHandler(@SessionAttribute("member") MemberVO member,
                               Model model) {
        model.addAttribute("member", member);
        return "redirect:/";
    }

    @GetMapping(value = "info")
    public String infoHandler() {
        return "member/info";
    }

    @PostMapping(value = "info")
    @ResponseBody
    public MemberVO infoEditHandler(HttpServletRequest request, @ModelAttribute(value = "member") MemberVO nicknameMember) {
        HttpSession session = request.getSession();
        MemberVO sessionMember = (MemberVO) session.getAttribute("member");
        sessionMember.setNickname(nicknameMember.getNickname());
        memberService.infoEditService(sessionMember);
        return sessionMember;
    }

    @GetMapping("logout")
    public String logoutHandler(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("member");
        return "redirect:/";
    }


}
