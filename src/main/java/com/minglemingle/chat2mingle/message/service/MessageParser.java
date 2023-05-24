package com.minglemingle.chat2mingle.message.service;

import com.google.gson.Gson;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

@Service
public class MessageParser {

    private final Gson gson;

    public MessageParser(Gson gson) {
        this.gson = gson;
    }

    public MessageDTO toDto(TextMessage textMessage) {
        return gson.fromJson(textMessage.getPayload(), MessageDTO.class);
    }
    public MessageDTO
    toDto(String message) {
        return gson.fromJson(message, MessageDTO.class);
    }
    public String toJson(MessageDTO messageDto) {
        return gson.toJson(messageDto, MessageDTO.class);
    }
}