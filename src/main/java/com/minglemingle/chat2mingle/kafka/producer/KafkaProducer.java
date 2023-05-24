package com.minglemingle.chat2mingle.kafka.producer;

import com.minglemingle.chat2mingle.message.service.MessageParser;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;
    private final MessageParser messageParser;

    public KafkaProducer(KafkaTemplate<String, MessageDTO> kafkaTemplate, MessageParser messageParser) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageParser = messageParser;
    }

    public void sendMessage(String topic, TextMessage message) {
        System.out.println(message.getPayload());
        MessageDTO messageDto = messageParser.toDto(message);
        kafkaTemplate.send(topic, messageDto);

    }
}