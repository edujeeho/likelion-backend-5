package com.example.aop.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.util.UUID;

@Component
public class TransactionLogFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(TransactionLogFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String requestUUID = UUID.randomUUID().toString().split("-")[0];
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        logger.info("[{}] start request: {} {}",
                requestUUID,
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI()
        );
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        chain.doFilter(requestWrapper, response);

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        logger.info("[{}], send response: {}",
                requestUUID, httpServletResponse.getStatus());
    }
}
