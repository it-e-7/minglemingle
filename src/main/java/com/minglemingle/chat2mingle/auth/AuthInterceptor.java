package com.minglemingle.chat2mingle.auth;

import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class AuthInterceptor implements HandlerInterceptor {

    private MemberService service;

    public AuthInterceptor(MemberService service) {
        this.service = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

        if (auth == null) {
            return true;
        }

        HttpSession session = request.getSession(false);
        if(session==null){
            response.sendRedirect("/member/login");
            return false;
        }

        MemberVO sessionMember = (MemberVO) session.getAttribute("member");
        MemberVO registeredMember = service.loginService(sessionMember);
        int accountType = registeredMember.getAccountType();
        String role = auth.role().toString();

        if(Objects.isNull(registeredMember)) {
            response.sendRedirect("/member/login");
            return false;
        }
        if (accountType==99 && "ADMIN".equals(role)) {
            return true;
        } else if (accountType==1 && "USER".equals(role)){
            return true;
        }
        response.sendRedirect("/product/home");
        return false;

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
