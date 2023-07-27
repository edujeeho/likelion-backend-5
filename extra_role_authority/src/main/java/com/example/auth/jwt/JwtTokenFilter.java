package com.example.auth.jwt;


import com.example.auth.entity.CustomUserDetails;
import com.example.auth.service.JpaUserDetailsManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Component
// 사용자가 Header에 포함한 JWT를 해석하고,
// 그에 따라 사용자가 인증된 상태인지를 확인하는 용도
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenUtils jwtTokenUtils;
    private final JpaUserDetailsManager userDetailsManager;

    public JwtTokenFilter(
            JwtTokenUtils jwtTokenUtils,
            JpaUserDetailsManager jpaUserDetailsManager
    ) {
        this.jwtTokenUtils = jwtTokenUtils;
        this.userDetailsManager = jpaUserDetailsManager;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader
                = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.split(" ")[1];
            if (jwtTokenUtils.validate(token)) {
                SecurityContext context
                        = SecurityContextHolder.createEmptyContext();
                // JWT에서 사용자 이름을 가져오기
                String username = jwtTokenUtils
                        .parseClaims(token)
                        .getSubject();
                UserDetails userDetails =
                        userDetailsManager.loadUserByUsername(username);

                AbstractAuthenticationToken authenticationToken
                        = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        token,
                        userDetails.getAuthorities()
                );

                // SecurityContext에 사용자 정보 설정
                context.setAuthentication(authenticationToken);
                // SecurityContextHolder에 SecurityContext 설정
                SecurityContextHolder.setContext(context);
                log.info("set security context with jwt");
            }
            // 아니라면 log.warn을 통해 알린다.
            else {
                log.warn("jwt validation failed");
            }
        }
        filterChain.doFilter(request, response);
    }
}










