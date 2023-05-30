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

    private MemberService service;

    public LoginInterceptor(MemberService service) {
        this.service = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        MemberVO checkUser = new MemberVO(null, null, email, null, 0, null, 0);

        MemberVO member = service.loginService(checkUser);
        HttpSession session = request.getSession(true);

        if (Objects.isNull(member)) {
            session.setAttribute("loginMessage", "notMember");
            response.sendRedirect("/chat2mingle/member/login");
            return false;
        }
        boolean validPassword = BCrypt.checkpw(password, member.getPassword());
        if (!validPassword) {
            session.setAttribute("loginMessage", "passwordFail");
            response.sendRedirect("/chat2mingle/member/login");
            return false;
        }
        if (member.getAccountStatus() == 11) {
            session.setAttribute("loginMessage", "account suspended");
            response.sendRedirect("/chat2mingle/member/login");
            return false;
        }

        member.setPassword(null);
        session.setAttribute("member", member);
        session.setAttribute("loginMessage", "success");

        if (member.getAccountType() == 99) {
            response.sendRedirect("/chat2mingle/admin/notice");
        }
        return true;

    }


}

