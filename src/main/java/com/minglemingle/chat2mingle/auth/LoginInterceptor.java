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
        String password =  request.getParameter("password");

        MemberVO checkUser = new MemberVO(null, null, email, null, 0, null, 0);

        MemberVO member = service.loginService(checkUser);
        
        // 입력받은 plaintext 비밀번호랑 hash 비교
        boolean validPassword = BCrypt.checkpw(password, member.getPassword());
        HttpSession session;
        if (!Objects.isNull(member)&& validPassword) {
            session = request.getSession(true);
            //해시 되어있는 유저의 비밀번호로 해시를 한번 더 해서 authToken 생성
            String authToken = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());
            member.setPassword(null);
            session.setAttribute("authToken", authToken);
            session.setAttribute("member", member);
            session.setAttribute("incorrectPw", false);


            return true;
        } else {
            session=request.getSession(true);
            session.setAttribute("incorrectPw", true);
            response.sendRedirect("/chat2mingle/member/login");

            return false;
        }
    }


}

