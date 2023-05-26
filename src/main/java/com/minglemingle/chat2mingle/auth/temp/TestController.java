package com.minglemingle.chat2mingle.auth.temp;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.auth.Auth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

//TODO: 이 controller 삭제시 연관된 views의 jsp 파일들 삭제 필요
@Controller
public class TestController {


    @GetMapping("/logintest")
    public String getLoginTest() {
        return "login-test";
    }

    @PostMapping("/processlogin")
    public String processLogin(@SessionAttribute(value="member") MemberVO member) {
        return "auth-home";
    }

    @GetMapping("tryauth")
    @Auth
    public String tryAuth() {
        return "get-auth";
    }
}
