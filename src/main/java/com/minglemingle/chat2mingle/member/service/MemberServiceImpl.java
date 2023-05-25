package com.minglemingle.chat2mingle.member.service;

import com.minglemingle.chat2mingle.member.mapper.MemberMapper;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberMapper mapper;

    public MemberServiceImpl(MemberMapper mapper) {
        this.mapper = mapper;
    }
    /*트랜잭션 처리는 PL/SQL로 처리할 것이기 때문에 에러가 리턴 된 것이 아니면
    항상 옳은 값이 삽입되어 있습니다. */

    /*    MemberVO infoService(String email){
           MemberVO member = new MemberVO();
            return member;
        };
        MemberVO loginService(MemberVO member){
            return member;
        };
        Boolean isEmailAvailable(String email){

        };
        Boolean isNicknameAvailable(String nickname){

        };*/
    @Override
    public Boolean registerMember(MemberVO member){
        Boolean result = false;
        try {
            result = mapper.insertMember(member);
        } catch(Exception e) {
            // false
        }
        return result;
    };

}

