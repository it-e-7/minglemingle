package com.minglemingle.chat2mingle.auth;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {

    Logger logger = LogManager.getLogger("case3");

    private MemberService service;

    public AuthInterceptor(MemberService service) {
        this.service = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.debug("AUTH INTERCEPTOR == PREHANDLE");

        // auth 있는지 확인
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

        if (auth == null) {
            return true;
        }

        // session 있는지 확인
        HttpSession session = request.getSession(false);
        if(session==null){
            response.sendRedirect("/chat2mingle/member/login");
            return false;
        }


        // 로그인한 멤버 토큰 확인
        MemberVO sessionMember = (MemberVO) session.getAttribute("member");
        MemberVO registeredMember = service.loginService(sessionMember);
        String authToken = (String) session.getAttribute("authToken");
        // 유저의 비밀번호(1번 해시된 유저의 비밀번호)와 그 값을 해시한 authoToken(로그인할 때 생성)
        boolean validToken = BCrypt.checkpw(registeredMember.getPassword(), authToken);
//        logger.debug("AUTH INTERCEPTOR == " + authToken);
//        logger.debug("AUTH INTERCEPTOR == " + loggedInMember.getPassword());

        if(registeredMember != null && validToken) {
            return true;
        } else {
            response.sendRedirect("/chat2mingle/member/login");
            return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
