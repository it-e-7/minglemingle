package com.minglemingle.chat2mingle.message.mapper;

import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MessageMapper {
    public MessageDTO selectOneMessage(@NonNull MessageDTO messageDTO);
    public List<MessageDTO> selectMessages(Integer offset);
    public int insertOneMessage(@NonNull MessageDTO messageDTO);
    public int deleteOneMessage(@NonNull MessageDTO messageDTO);
}
