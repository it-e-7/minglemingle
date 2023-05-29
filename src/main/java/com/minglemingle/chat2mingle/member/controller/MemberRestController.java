package com.minglemingle.chat2mingle.member.controller;

import com.minglemingle.chat2mingle.member.service.MemberService;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
public class MemberRestController {

    private MemberService service;

    public MemberRestController(MemberService memberService) {
        this.service = memberService;
    }

    @PostMapping(value = "checkNickname")
    public ResponseEntity<Object> checkUserNickName(@RequestBody MemberVO memberVO) {
        boolean isValidNickname = service.isNicknameAvailable(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(isValidNickname);
    }
    @PostMapping(value = "checkEmail")
    public ResponseEntity<Object> checkUserEmail(@RequestBody MemberVO memberVO) {
        boolean isValidEmail = service.isEmailAvailable(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(isValidEmail);
    }
}
