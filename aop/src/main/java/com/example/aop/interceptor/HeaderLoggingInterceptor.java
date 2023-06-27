package com.example.aop.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

@Component
public class HeaderLoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(HeaderLoggingInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws IOException {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("pre handling of {}", handlerMethod.getMethod().getName());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            logger.debug("{}: {}", headerName, request.getHeader(headerName));
        }
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("post handling of {}", handlerMethod.getMethod().getName());
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName: headerNames) {
            logger.debug("{}: {}", headerName, response.getHeader(headerName));
        }
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception ex
    ) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("after completion of {}", handlerMethod.getMethod().getName());
        if (ex != null) logger.error("Exception occurred while processing", ex);
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName: headerNames) {
            logger.debug("{}: {}", headerName, response.getHeader(headerName));
        }
    }
}

