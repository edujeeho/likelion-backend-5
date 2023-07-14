package com.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Component
// Header 조작 없이 바로 기록하는 필터
public class LoggingFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain
    ) {
        String path = exchange.getRequest().getPath().toString();
        log.trace("Executed filter in PreLoggingFilter");
        long timeStart = Instant.now().toEpochMilli();

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {

            log.info("Execution Time Path: {}, timediff(ms): {}",
                    path, Instant.now().toEpochMilli() - timeStart);
        }));
    }
}
