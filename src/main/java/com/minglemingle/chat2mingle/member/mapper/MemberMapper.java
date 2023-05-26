package com.minglemingle.chat2mingle.member.mapper;

import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.lang.NonNull;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.Nullable;

@Mapper
public interface MemberMapper {
    public Boolean insertMember(@NonNull MemberVO member) throws Exception;

    public MemberVO selectOneMember(@Nullable MemberVO member) throws Exception;;

    public void deleteMember(MemberVO member) throws Exception;

    public MemberVO updateMember(MemberVO member) throws Exception;
}