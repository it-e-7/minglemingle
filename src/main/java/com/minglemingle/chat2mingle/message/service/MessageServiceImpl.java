package com.minglemingle.chat2mingle.message.service;

import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.aspect.transaction.annotation.Transactional;
import com.minglemingle.chat2mingle.message.mapper.MessageMapper;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import com.minglemingle.chat2mingle.websocket.service.WebSocketSessionManager;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final WebSocketSessionManager webSocketSessionManager;
    private final MessageParser messageParser;
    private final MessageMapper messageMapper;

    private final CommandMessageFormatter commandFormatter;

    public MessageServiceImpl(WebSocketSessionManager webSocketSessionManager,
                              MessageParser messageParser,
                              MessageMapper messageMapper,
                              CommandMessageFormatter commandFormatter) {
        this.webSocketSessionManager = webSocketSessionManager;
        this.messageParser = messageParser;
        this.messageMapper = messageMapper;
        this.commandFormatter = commandFormatter;
    }


    @Override
    public void broadcast(@NonNull MessageDTO messageDto) {

        TextMessage textMessage = new TextMessage(messageParser.toJson(messageDto));
        try {
            Integer channel = messageDto.getChannel();
            for (WebSocketSession session : webSocketSessionManager.getSessions(channel)) {
                session.sendMessage(textMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void broadcast(@NonNull String message) {
        broadcast(messageParser.toDto(message));
    }

    @Override
    public MessageDTO getOneMessageByMessageId(@NonNull MessageDTO messageDTO) {
        return messageMapper.selectOneMessageByMessageId(messageDTO);
    }

    @DebugLog
    @Override
    public List<MessageDTO> getMessageListAfterMessageId(@NonNull MessageDTO messageDTO) {
        if (messageDTO.getMessageId() == null) {
            messageDTO.setMessageId(0);
        }
        return messageMapper.selectMessageListAfterMessageId(messageDTO);
    }

    @Override
    @Transactional
    public Integer insertOneMessage(@NonNull MessageDTO messageDTO) throws SQLException {
        return messageMapper.insertOneMessage(messageDTO);
    }

    @Override
    @Transactional
    public Integer insertOneMessage(@NonNull String messageString) throws SQLException {
        return insertOneMessage(messageParser.toDto(messageString));
    }

    @Override
    public Integer deleteMessageSent(@NonNull MessageDTO messageDTO) {
//        Session Attribute
        MessageDTO admin_message = commandFormatter.makeDeleteCommandMessage(messageDTO,
                "sychoi");
        broadcast(admin_message);
        return messageMapper.deleteOneMessage(messageDTO);
    }
}
