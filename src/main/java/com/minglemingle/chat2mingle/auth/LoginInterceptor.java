package com.minglemingle.chat2mingle.auth;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.mindrot.jbcrypt.BCrypt;


public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = LogManager.getLogger("case3");

    private MemberService service;

    public LoginInterceptor(MemberService service) {
        this.service = service;
    }

    @Override
    @DebugLog
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.debug("AUTH INTERCEPTOR >> PREHANDLE");

        String email = request.getParameter("email");
        String password =  request.getParameter("password");

        MemberVO checkUser = new MemberVO(null, null, email, null, 0, null, 0);

        MemberVO member = service.loginService(checkUser);
        
        // 입력받은 plaintext 비밀번호랑 hash 비교
        boolean validPassword = BCrypt.checkpw(password, member.getPassword());

        if (member != null && validPassword) {
            HttpSession session = request.getSession(true);
            //해시 되어있는 유저의 비밀번호로 해시를 한번 더 해서 authToken 생성
            String authToken = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());
            member.setPassword(null);
            session.setAttribute("authToken", authToken);
            session.setAttribute("member", member);

            return true;
        } else {
            response.sendRedirect("/chat2mingle/member/login");
            return false;
        }
    }


}

