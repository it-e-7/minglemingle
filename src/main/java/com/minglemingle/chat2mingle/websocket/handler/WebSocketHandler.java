package com.minglemingle.chat2mingle.websocket.handler;

import com.minglemingle.chat2mingle.kafka.producer.KafkaProducer;
import com.minglemingle.chat2mingle.websocket.service.WebSocketSessionManager;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
        kafkaProducer.sendMessage(message);
    }
    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        if (session.getUri() == null) {
            // do something to delete session
            return;
        }
        UriComponents uriComponents = UriComponentsBuilder.fromUri(session.getUri()).build();

        // Retrieve the query string parameter value
        String channelFromQuery = uriComponents.getQueryParams().getFirst("channel");
        if (channelFromQuery == null) {
            // do something to delete session
            // invalid Access
            return;
        }
        Integer channel = Integer.valueOf(channelFromQuery);

        session.getAttributes().put("channel", channel);
        webSocketSessionManager.add(channel, session);

    }
    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session,
                                      @NonNull CloseStatus status) throws Exception {
        Integer channel = (Integer) session.getAttributes().get("channel");
        if (channel == null) {
            return;
        }
        webSocketSessionManager.remove(channel, session);
    }
}
