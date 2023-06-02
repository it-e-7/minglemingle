package com.minglemingle.chat2mingle.auth;

import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;


public class LoginInterceptor implements HandlerInterceptor {

    private MemberService memberService;

    public LoginInterceptor(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MemberVO checkUser = new MemberVO(null, null, email, null, 0, null, 0);

        MemberVO member = memberService.loginService(checkUser);
        HttpSession session = request.getSession(true);

        System.out.println("LOGIN MEMBER" + member);
        if (Objects.isNull(member)) {
            response.sendRedirect("/chat2mingle/member/login?loginMessage=notMember");
            return false;
        }
//        System.out.println(password);
//        System.out.println(member.getPassword());
        boolean validPassword;
        try {
            validPassword= BCrypt.checkpw(password, member.getPassword());
        } catch (Exception e) {
            response.sendRedirect("/chat2mingle/member/login?loginMessage=passwordFail");
            return false;
        }
        if (!validPassword) {
            response.sendRedirect("/chat2mingle/member/login?loginMessage=passwordFail");
            return false;
        }
        if (member.getAccountStatus() == 11) {
            response.sendRedirect("/chat2mingle/member/login?loginMessage=accountSuspended");
            return false;
        }

        member.setPassword(null);
        session.setAttribute("member", member);

        if (member.getAccountType() == 99) {
            response.sendRedirect("/chat2mingle/admin/notice");
        }
        return true;

    }


}

