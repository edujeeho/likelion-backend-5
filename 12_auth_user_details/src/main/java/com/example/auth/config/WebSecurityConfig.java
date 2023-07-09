package com.example.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authHttp -> authHttp
                                .requestMatchers(
                                        "/no-auth",
                                        "/users/login"
                                )
                                .permitAll()
                                .requestMatchers(
                                        "/",
                                        "/users/register"
                                )
                                .anonymous()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/users/login")
                                .defaultSuccessUrl("/users/my-profile")
                                .failureUrl("/users/login?fail")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutUrl("/users/logout")
                                .logoutSuccessUrl("/users/login")
                )
        ;
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
