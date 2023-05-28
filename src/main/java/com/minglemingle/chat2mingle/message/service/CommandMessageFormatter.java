package com.minglemingle.chat2mingle.message.service;


import com.minglemingle.chat2mingle.message.util.MessageConst;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;


@Service
public class CommandMessageFormatter {
    public MessageDTO makeBaseCommandMessage(MessageDTO messageDTO, String admin_name) {
        return MessageDTO.builder()
                .nickname(admin_name)
                .channel(messageDTO.getChannel())
                .messageType(MessageConst.ADMIN_MESSAGE_TYPE)
                .sentAt(Timestamp.from(Instant.now()))
                .build();
    }
    public MessageDTO makeDeleteCommandMessage(MessageDTO messageDTO, String admin_name) {
        MessageDTO commandMessage = makeBaseCommandMessage(messageDTO, admin_name);
        commandMessage.setContent(MessageConst.DELETE_COMMAND_PREFIX + messageDTO.getMessageId());
        return commandMessage;

    }
}
