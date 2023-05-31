package com.minglemingle.chat2mingle.message.mapper;

import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.NonNull;

import java.util.List;

@Mapper
public interface MessageMapper {
    MessageDTO selectOneMessageByMessageId(@NonNull MessageDTO messageDTO);
    List<MessageDTO> selectMessageListAfterMessageId(@NonNull MessageDTO messageDTO);
    int insertOneMessage(@NonNull MessageDTO messageDTO);
    int deleteOneMessage(@NonNull MessageDTO messageDTO);
}
