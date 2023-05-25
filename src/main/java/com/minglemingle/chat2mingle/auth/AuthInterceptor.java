package com.minglemingle.chat2mingle.auth;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.auth.temp.MemberService;
import com.minglemingle.chat2mingle.auth.temp.MemberVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//TODO: servlet-context에서 interceptor exclude mapping path login post mapping 루트로 변경
public class AuthInterceptor implements HandlerInterceptor {

    Logger logger = LogManager.getLogger("case3");

    //TODO: edit import
    private MemberService service;

    public AuthInterceptor(MemberService service) {
        this.service = service;
    }

    //    @DebugLog
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("AUTH INTERCEPTOR == PREHANDLE");

        // auth 있는지 확인
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

        if (auth == null) {
            return true;
        }

        // session 있는지 확인
        HttpSession session = request.getSession(false);
        if(session==null){
            // TODO: logintest 루트 수정
            response.sendRedirect("/chat2mingle/logintest");
            return false;
        }


        // 로그인한 멤버 확인
        MemberVO member = (MemberVO) session.getAttribute("member");
        //TODO: service 로그인 method 수정
        MemberVO loggedInMember = service.loginUser(member);

        if(loggedInMember == null) {
            //TODO: logintest 루트 수정
            response.sendRedirect("/chat2mingle/logintest");
            return false;
        } else {
            return true;
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
