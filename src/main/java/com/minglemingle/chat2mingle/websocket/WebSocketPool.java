package com.minglemingle.chat2mingle.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
public class WebSocketPool {
    private final Map<Integer, Set<WebSocketSession>> websockets;
}