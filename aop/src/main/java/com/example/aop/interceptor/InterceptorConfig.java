package com.example.aop.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private final HeaderLoggingInterceptor headerLoggingInterceptor;

    public InterceptorConfig(
            HeaderLoggingInterceptor headerLoggingInterceptor
    ) {
        this.headerLoggingInterceptor = headerLoggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(headerLoggingInterceptor)
                .addPathPatterns("/users");
    }
}
