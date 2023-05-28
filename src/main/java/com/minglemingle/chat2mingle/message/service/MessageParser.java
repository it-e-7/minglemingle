package com.minglemingle.chat2mingle.message.service;

import com.google.gson.Gson;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

@Service
public class MessageParser {

    private final Gson gson;

    @Value("${kafka.topic_prefix}")
    private String topicPrefix;

    public MessageParser(Gson gson) {
        this.gson = gson;
    }

    public MessageDTO toDto(TextMessage textMessage) {
        return gson.fromJson(textMessage.getPayload(), MessageDTO.class);
    }
    public MessageDTO toDto(String message) {
        return gson.fromJson(message, MessageDTO.class);
    }
    public String toJson(MessageDTO messageDTO) {
        return gson.toJson(messageDTO, MessageDTO.class);
    }

    public String parseTopic(MessageDTO messageDTO) {
        return topicPrefix + messageDTO.getChannel();
    }
}