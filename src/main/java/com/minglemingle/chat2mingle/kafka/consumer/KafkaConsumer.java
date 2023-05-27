package com.minglemingle.chat2mingle.kafka.consumer;

import com.minglemingle.chat2mingle.message.service.MessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
class KafkaConsumer {

    private final MessageService messageService;


    public KafkaConsumer(MessageService messageService) {
        this.messageService = messageService;
    }

//    public void parseAndSendMessage

    @KafkaListener(topics = "channel1")
    public void listenerChannel1(@Payload String message) {
        messageService.broadcast(message);
    }
    @KafkaListener(topics = "channel2")
    public void listenerChannel2(@Payload String message) {
        messageService.broadcast(message);
    }
    @KafkaListener(topics = "channel3")
    public void listenerChannel3(@Payload String message) {
        messageService.broadcast(message);
    }


}
