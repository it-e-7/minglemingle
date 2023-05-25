package com.minglemingle.chat2mingle.auth.temp;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public MemberVO loginUser(MemberVO memberVO) {
        return new MemberVO(memberVO.getMember_id(), "nickname1", "hong@gmail.com",
                memberVO.getPassword(), 1, "someimagepath", 1);

    }
}
