package com.minglemingle.chat2mingle.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String memberId;
    private String nickname;
    private String email;
    private String password;
    private Integer accountType;
    private String profileImagePath;
    private Integer accountStatus;
}