package com.example.contents.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;


    @Bean("dcn")
    public String driverClassName() {
        return driverClassName;
    }
}
