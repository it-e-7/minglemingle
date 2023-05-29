package com.minglemingle.chat2mingle.websocket.service;

import org.springframework.web.socket.WebSocketSession;

import java.util.Set;

public interface WebSocketSessionManager {
    Set<WebSocketSession> getSessions(Integer channel);
    public void add(Integer channel, WebSocketSession session);
    public void remove(Integer channel, WebSocketSession session);
}