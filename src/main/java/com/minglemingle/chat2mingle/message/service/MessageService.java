package com.minglemingle.chat2mingle.message.service;

import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.lang.Nullable;

import java.util.List;

public interface MessageService {
    void broadcast(MessageDTO messageDTO);

    MessageDTO getOneMessage(MessageDTO messageDTO);

    List<MessageDTO> getMessages(@Nullable Integer offset);

    List<MessageDTO> getAllReportedMessage(MessageDTO messageDTO);

    int insertOneMessage(MessageDTO messageDTO);

    int deleteMessageSent(MessageDTO messageDto);

}
