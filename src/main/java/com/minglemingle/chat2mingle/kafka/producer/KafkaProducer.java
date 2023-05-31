package com.minglemingle.chat2mingle.kafka.producer;

import com.minglemingle.chat2mingle.message.service.MessageParser;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.List;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;
    private final MessageParser messageParser;


    @Value("${kafka.database_topic}")
    private String databaseTopic;

    public KafkaProducer(KafkaTemplate<String, MessageDTO> kafkaTemplate, MessageParser messageParser) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageParser = messageParser;
    }

    public void sendMessage(MessageDTO messageDTO) {
        String topic = messageParser.parseTopic(messageDTO);
        kafkaTemplate.send(topic, messageDTO);
        kafkaTemplate.send(databaseTopic, messageDTO);
    }
    public void sendMessage(TextMessage textMessage) {
        sendMessage(messageParser.toDto(textMessage));
    }
    public void sendMessage(List<MessageDTO> messageDTOList) {
        for (MessageDTO messageDTO : messageDTOList) {
            sendMessage(messageDTO);
        }
    }
}