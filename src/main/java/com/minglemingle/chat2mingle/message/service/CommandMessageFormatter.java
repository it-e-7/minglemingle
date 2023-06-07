package com.minglemingle.chat2mingle.message.service;


import com.minglemingle.chat2mingle.util.SystemConst;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;


@Service
public class CommandMessageFormatter {
    public MessageDTO makeBaseCommandMessage(MessageDTO messageDTO, String adminName) {
        return MessageDTO.builder()
                .nickname(adminName)
                .channel(messageDTO.getChannel())
                .messageType(SystemConst.MESSAGE_TYPE_ADMIN)
                .sentAt(Timestamp.from(Instant.now()))
                .build();
    }
    public MessageDTO makeDeleteCommandMessage(MessageDTO messageDTO, String adminName) {
        MessageDTO commandMessage = makeBaseCommandMessage(messageDTO, adminName);
        commandMessage.setContent(SystemConst.DELETE_COMMAND_PREFIX + messageDTO.getMessageId());
        return commandMessage;

    }
}
