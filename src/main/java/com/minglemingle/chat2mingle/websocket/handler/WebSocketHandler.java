package com.minglemingle.chat2mingle.websocket.handler;

import com.minglemingle.chat2mingle.kafka.KafkaConst;
import com.minglemingle.chat2mingle.kafka.producer.KafkaProducer;
import com.minglemingle.chat2mingle.websocket.service.WebSocketSessionManager;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final KafkaProducer kafkaProducer;

    private final WebSocketSessionManager webSocketSessionManager;

    public WebSocketHandler(KafkaProducer kafkaProducer,
                            WebSocketSessionManager webSocketSessionManager) {
        this.kafkaProducer = kafkaProducer;
        this.webSocketSessionManager = webSocketSessionManager;
    }

    @Override
    public void handleTextMessage(@NonNull WebSocketSession session,
                                  @NonNull TextMessage message) throws Exception {
        kafkaProducer.sendMessage(KafkaConst.GROUP_ID, message);
    }
    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        webSocketSessionManager.add(2, session);

    }
    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session,
                                      @NonNull CloseStatus status) throws Exception {
        webSocketSessionManager.remove(2, session);
    }
}
