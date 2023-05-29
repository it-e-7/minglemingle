package com.minglemingle.chat2mingle.member.mapper;

import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.lang.NonNull;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.Nullable;

@Mapper
public interface MemberMapper {
    Boolean insertMember(@NonNull MemberVO member) throws Exception;

    MemberVO selectOneMemberByEmail(@Nullable MemberVO member) throws Exception;

    void deleteMember(MemberVO member) throws Exception;

    MemberVO updateMember(MemberVO member) throws Exception;

    MemberVO selectOneMemberByNickname(MemberVO member);
}