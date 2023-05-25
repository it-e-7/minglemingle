package com.minglemingle.chat2mingle.member.mapper;
import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.lang.NonNull;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public Boolean insertMember(@NonNull MemberVO member);
/*  public void deleteMemver(MemberVO member) throws Exception;
    public void updateMemver(MemberVO member) throws Exception;*/
}