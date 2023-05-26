package com.minglemingle.chat2mingle.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping(value = "test")
    public void testHandler(){
        return "test";
    }
}
