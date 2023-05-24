package com.minglemingle.chat2mingle.kafka.consumer;

import com.minglemingle.chat2mingle.message.service.MessageParser;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
class KafkaConsumer {

    private final MessageService messageService;

    private final MessageParser messageParser;

    public KafkaConsumer(MessageService messageService, MessageParser messageParser) {
        this.messageService = messageService;
        this.messageParser = messageParser;
    }

//    public void parseAndSendMessage

    @KafkaListener(topics = "my-topic")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        MessageDTO messageDto = messageParser.toDto(message);

        messageService.broadcast(messageDto);
    }


}
