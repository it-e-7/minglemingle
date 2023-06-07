package com.minglemingle.chat2mingle.websocket.service;

public interface WebSocketVisitorService {
    int updateVisitor(Integer channel, String nickname);
    int selectAllVisitor (Integer channel);
}