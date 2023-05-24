package com.minglemingle.chat2mingle.message.service;

import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import com.minglemingle.chat2mingle.websocket.service.WebSocketSessionManager;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final WebSocketSessionManager webSocketSessionManager;
    private final MessageParser messageParser;

    public MessageServiceImpl(WebSocketSessionManager webSocketSessionManager,
                              MessageParser messageParser) {
        this.webSocketSessionManager = webSocketSessionManager;
        this.messageParser = messageParser;
    }

    @Override
    public void broadcast(MessageDTO messageDto) {
        TextMessage textMessage = new TextMessage(messageParser.toJson(messageDto));
        try {
            for (Integer channel: messageDto.getChannels()) {
                for (WebSocketSession session : webSocketSessionManager.getSessions(channel)) {
                    session.sendMessage(textMessage);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageDTO getOneMessage(MessageDTO messageDTO) {
        return null;
    }

    @Override
    public List<MessageDTO> getMessages(Integer offset) {
        return null;
    }

    @Override
    public List<MessageDTO> getAllReportedMessage(MessageDTO messageDTO) {
        return null;
    }

    @Override
    public int insertOneMessage(MessageDTO messageDTO) {
        return 0;
    }

    @Override
    public int deleteMessageSent(MessageDTO messageDto) {
        return 0;
    }
}
