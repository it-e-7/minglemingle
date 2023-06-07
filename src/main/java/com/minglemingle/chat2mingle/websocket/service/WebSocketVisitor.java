package com.minglemingle.chat2mingle.websocket.service;

public interface WebSocketVisitor {
    public void updateVisitor(Integer channel,String nickname);
    public int selectAllVisitor (Integer channel);
}