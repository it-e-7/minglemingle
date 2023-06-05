package com.minglemingle.chat2mingle.websocket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class WebSocketPoolConfig {

    @Value("${message.channel.count}")
    private int messageChannelCount;

    @Bean
    public WebSocketPool webSocketPool() {
        WebSocketPool webSocketPool = new WebSocketPool(new ConcurrentHashMap<>());
        for (int i = 0; i < messageChannelCount; i++) {
            webSocketPool.getWebsockets().put(i, new HashSet<>());
        }
        return webSocketPool;
    }
}
