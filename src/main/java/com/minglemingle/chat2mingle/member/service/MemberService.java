package com.minglemingle.chat2mingle.member.service;

import com.minglemingle.chat2mingle.member.vo.MemberVO;

public interface MemberService {
    /**
     * Member를 생성하는 서비스
     *
     * @param : String email, String nickname, MemberVO member
     * @return : 정상적으로 처리한 여부, MemberVO
     * @throws : 정상적인 리턴을 받지 못한 경우 exception
     * @version : 1.0.0
     * @author : noino
     * @see : MemberService#infoService(String user_id) 회원정보를 불러오는 함수
     * @see : MemberService#infoEditService(String user_id) 회원정보를 수정하는 함수
     * @see : MemberService#loginService(MemberVO member) 로그인을 담당하는 함수
     * @see : MemberService#isEmailAvailable(String email) 이메일 중복 확인 함수
     * @see : MemberService#isNicknameAvailable(String nickname) 닉네임 중복 확인 함수
     * @see : MemberService#registerMember(MemberVO member) 회원가입을 담당하는 함수
     */

    Boolean registerMember(MemberVO member);

    MemberVO infoService(MemberVO member);

    MemberVO infoEditService(MemberVO member);

    Boolean isEmailAvailable(MemberVO member);

    Boolean isNicknameAvailable(MemberVO member);

    MemberVO loginService(MemberVO member);

    boolean changeAccountStatus(MemberVO member);
}
