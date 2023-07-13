package com.example.auth.config;

import com.example.auth.jwt.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;

    public WebSecurityConfig(JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authHttp -> authHttp
                                .requestMatchers(
                                        "/no-auth",
                                        "/token/issue",
                                        "/users/login"
                                )
                                .permitAll()
                                .requestMatchers(
                                        "/",
                                        "/users/register"
                                )
                                .anonymous()
//                                .requestMatchers(
//                                        "/re-auth",
//                                        "/users/my-profile",
//                                        "/token/secured"
//                                )
//                                .authenticated()
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(
                        sessionManagement -> sessionManagement
                                .sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtTokenFilter, AuthorizationFilter.class)
//                .formLogin(
//                        formLogin -> formLogin
//                                .loginPage("/users/login")
//                                .defaultSuccessUrl("/users/my-profile")
//                                .failureUrl("/users/login?fail")
//                                .permitAll()
//                )
//                .logout(
//                        logout -> logout
//                                .logoutUrl("/users/logout")
//                                .logoutSuccessUrl("/users/login")
//                )
        ;
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
