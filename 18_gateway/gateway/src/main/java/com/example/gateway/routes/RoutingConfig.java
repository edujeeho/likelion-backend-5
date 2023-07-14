package com.example.gateway.routes;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RoutingConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("auth", predicate -> predicate
                        .path("/auth/**")
                        .filters(filter -> filter
                                .rewritePath(
                                        "/auth/(?<path>.*)",
                                        "/${path}"
                                )
                        )
                        .uri("http://localhost:8081"))
                .route("articles", predicate -> predicate
                        .path("/articles/**")
                        .uri("http://localhost:8082")
                )
                .build();
    }
}
