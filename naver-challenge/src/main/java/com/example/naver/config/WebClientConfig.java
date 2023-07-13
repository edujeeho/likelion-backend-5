package com.example.naver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${ncp.api.client-id}")
    private String ncpApiClientId;

    @Value("${ncp.api.client-secret}")
    private String ncpApiClientSecret;

}
