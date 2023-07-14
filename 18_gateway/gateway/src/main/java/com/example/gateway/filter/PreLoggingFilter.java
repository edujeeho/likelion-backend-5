package com.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class PreLoggingFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain
    ) {
        log.trace("Executed filter in PreLoggingFilter");
        ServerHttpRequest httpRequest = exchange.getRequest();
        httpRequest.mutate()
                .headers(httpHeaders -> {
                    httpHeaders.add(
                            "x-gateway-request-id",
                            UUID.randomUUID().toString()
                    );
                    httpHeaders.add(
                            "x-gateway-request-time",
                            String.valueOf(Instant.now().toEpochMilli())
                    );
                });

        return chain.filter(exchange);
    }
}
