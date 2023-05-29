package com.minglemingle.chat2mingle.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketPool {
    public static Map<Integer, Set<WebSocketSession>> websockets = new ConcurrentHashMap<>();
    static {
        for (int i = 0; i < 5; i++) {
            websockets.put(i, new HashSet<>());
        }
    }
}