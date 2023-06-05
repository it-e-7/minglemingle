package com.minglemingle.chat2mingle.kafka.consumer;

import com.minglemingle.chat2mingle.message.service.MessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
class KafkaConsumer {

    private final MessageService messageService;

    public KafkaConsumer(MessageService messageService) {
        this.messageService = messageService;
    }

//    @KafkaListener(topics = "channel1")
//    public void listenerChannel1(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel2")
//    public void listenerChannel2(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel3")
//    public void listenerChannel3(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel4")
//    public void listenerChannel4(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel5")
//    public void listenerChannel5(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel6")
//    public void listenerChannel6(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel7")
//    public void listenerChannel7(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel8")
//    public void listenerChannel8(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel9")
//    public void listenerChannel9(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel10")
//    public void listenerChannel10(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "channel11")
//    public void listenerChannel11(@Payload String message) {
//        messageService.broadcast(message);
//    }
//
//    @KafkaListener(topics = "database")
//    public void listenerDatabase(@Payload String message) throws SQLException {
//        messageService.insertOneMessage(message);
//    }
}
