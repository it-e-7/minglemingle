package com.minglemingle.chat2mingle.auth;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.auth.temp.MemberService;
import com.minglemingle.chat2mingle.auth.temp.MemberVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//TODO: servlet-context에서 interceptor mapping path login post mapping 루트로 변경
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = LogManager.getLogger("case3");

    // TODO: Merge시 MemberService 임포트 수정 (현재는 temp 사용)
    private MemberService service;

    public LoginInterceptor(MemberService service) {
        this.service = service;
    }

    @Override
    @DebugLog
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.debug("AUTH INTERCEPTOR >> PREHANDLE");
        String id = request.getParameter("memberId");
        String pw =  request.getParameter("memberPw");
        MemberVO checkUser = new MemberVO(id, null, null, pw, 0, null, 0);

        MemberVO member = service.loginUser(checkUser);

        //TODO: memberVO 객체 전체를 저장하면 pw도 같이 저장 되니까
        // 다른 커맨드 객체를 만들어서 저장 필요 -> Member branch merge시 수정
        if (member != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("member", member);
            return true;
        } else {
            //TODO: login 페이지 controller로 수정
            response.sendRedirect("/chat2mingle/logintest");
            return false;
        }
    }


}

