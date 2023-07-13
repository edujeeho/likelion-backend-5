package com.example.chat.config;

import com.example.chat.SimpleChatHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final SimpleChatHandler simpleChatHandler;

    public WebSocketConfig(
            SimpleChatHandler simpleChatHandler
    ) {
        this.simpleChatHandler = simpleChatHandler;
    }

    @Override
    // WebSocketHandler 객체를 등록하기 위한 메소드
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(simpleChatHandler, "ws/chat")
                .setAllowedOrigins("*");
    }
}
