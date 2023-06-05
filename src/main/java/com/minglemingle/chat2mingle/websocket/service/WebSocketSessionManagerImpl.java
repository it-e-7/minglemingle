package com.minglemingle.chat2mingle.websocket.service;

import com.minglemingle.chat2mingle.websocket.WebSocketPool;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Set;

@Service
public class WebSocketSessionManagerImpl implements WebSocketSessionManager {

    private final WebSocketPool webSocketPool;

    public WebSocketSessionManagerImpl(WebSocketPool webSocketPool) {
        this.webSocketPool = webSocketPool;
    }

    @Override
    public Set<WebSocketSession> getSessions(Integer channel) {
        return webSocketPool.getWebsockets().get(channel);
    }

    @Override
    public void add(Integer channel, WebSocketSession session) {
        webSocketPool.getWebsockets().get(channel).add(session);
    }

    @Override
    public void remove(Integer channel, WebSocketSession session) {
        webSocketPool.getWebsockets().get(channel).remove(session);
    }
}