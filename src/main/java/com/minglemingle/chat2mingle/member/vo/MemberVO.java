package com.minglemingle.chat2mingle.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String member_id;
    private String nickname;
    private String email;
    private String password;
    private int account_type;
    private String profile_image_path;
    private int account_status;
}
