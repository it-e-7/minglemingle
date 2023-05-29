package com.minglemingle.chat2mingle.websocket.service;

import com.minglemingle.chat2mingle.websocket.WebSocketPool;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Set;

@Service
public class WebSocketSessionManagerImpl implements WebSocketSessionManager {
    @Override
    public Set<WebSocketSession> getSessions(Integer channel) {
        return WebSocketPool.websockets.get(channel);
    }

    @Override
    public void add(Integer channel, WebSocketSession session) {
        WebSocketPool.websockets.get(channel).add(session);
    }

    @Override
    public void remove(Integer channel, WebSocketSession session) {
        WebSocketPool.websockets.get(channel).remove(session);
    }
}