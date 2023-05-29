package com.minglemingle.chat2mingle.member.service;

import com.minglemingle.chat2mingle.member.mapper.MemberMapper;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {
    private MemberMapper mapper;

    public MemberServiceImpl(MemberMapper mapper) {
        this.mapper = mapper;
    }
    /*트랜잭션 처리는 PL/SQL로 처리할 것이기 때문에 에러가 리턴 된 것이 아니면
    항상 옳은 값이 삽입되어 있습니다. */

    @Override
    public Boolean registerMember(MemberVO member) {
        Boolean result = false;
        String encryptedPassword = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());

        member.setPassword(encryptedPassword);
        try {
            result = mapper.insertMember(member);
        } catch (Exception e) {
            // false
        }
        return result;
    }

    @Override
    public MemberVO infoService(MemberVO member) {
        MemberVO result = new MemberVO();
        try {
            result = mapper.selectOneMemberByEmail(member);
        } catch (Exception e) {
            //
        }
        return result;
    }

    @Override
    public MemberVO infoEditService(MemberVO member) {
        MemberVO result = new MemberVO();
        try {
            result = mapper.updateMember(member);

        } catch (Exception e) {
            //
        }
        return result;
    }

    @Override
    public Boolean isEmailAvailable(MemberVO member) {
        MemberVO result;
        try {
            result = mapper.selectOneMemberByEmail(member);
            if (result == null)
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public Boolean isNicknameAvailable(MemberVO member) {
        MemberVO result;
        try {
            result = mapper.selectOneMemberByNickname(member);
            if (result == null)
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public MemberVO loginService(MemberVO member) {
        MemberVO result = new MemberVO();
        try {
            result = mapper.selectOneMemberByEmail(member);
            return result;
        } catch (Exception e) {
            // false
        }
        return result;
    }
}

