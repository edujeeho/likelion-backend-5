package com.example.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// 5.7 버전 이전: extends WebSecurityConfigurerAdapter
// 6.1 버전 이후: Builder -> Lambda 를 이용 DSL 기반 설정
@Configuration
// @EnableWebSecurity  // 2.1 버전 이후 Spring Boot Starter Security 에서는 필수 아님
public class WebSecurityConfig {
    @Bean  // 메소드의 결과를 Bean 객체로 등록해주는 어노테이션
    public SecurityFilterChain securityFilterChain(
            // DI 자동으로 설정됨, 빌더 패턴 처럼 쓴다.
            HttpSecurity http
    )
        throws Exception {
        http
                // CSRF: Cross Site Request Forgery
                .csrf(AbstractHttpConfigurer::disable)
                // 1. requestMatchers를 통해 설정할 URL 지정
                // 2. permitAll(), authenticated() 등을 통해 어떤 사용자가
                //    접근 가능한지 설정
                .authorizeHttpRequests(
                        authHttp -> authHttp // HTTP 요청 허가 관련 설정을 하고 싶다.
                        // requestMatchers == 어떤 URL로 오는 요청에 대하여 설정하는지
                        // permitAll() == 누가 요청해도 허가한다.
                                .requestMatchers(
                                        "/no-auth",
                                        "/token/issue"
                                )
                                .permitAll()
                                .requestMatchers(
                                        "/re-auth",
                                        "/users/my-profile"
                                )
                                .authenticated()  // 인증이 된 사용자만 허가
                                .requestMatchers(
                                        "/",
                                        "/users/register"
                                )
                                .anonymous()  // 인증이 되지 않은 사용자만 허가
                )
                .sessionManagement(
                        sessionManagement -> sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
//                // form 을 이용한 로그인 관련 설정
//                .formLogin(
//                        formLogin -> formLogin
//                                // 로그인 하는 페이지(경로)를 지정
//                                .loginPage("/users/login")
//                                // 로그인 성공시 이동하는 페이지(경로)
//                                .defaultSuccessUrl("/users/my-profile")
//                                // 로그인 실패시 이동하는 페이지(경로)
//                                .failureUrl("/users/login?fail")
//                                // 로그인 과정에서 필요한 경로들을
//                                // 모든 사용자가 사용할 수 있게끔 권한설정
//                                .permitAll()
//                )
//                // 로그아웃 관련 설정
//                // 로그인 -> 쿠키를 통해 세션을 생성
//                //       아이디와 비밀번호
//                // 로그아웃 -> 세션을 제거
//                //        -> 세션 정보만 있으면 제거 가능
//                .logout(
//                        logout -> logout
//                                // 로그아웃 요청을 보낼 URL
//                                // 어떤 UI에 로그아웃 기능을 연결하고 싶으면
//                                // 해당 UI가 /users/logout으로 POST 요청을
//                                // 보내게끔
//                                .logoutUrl("/users/logout")
//                                // 로그아웃 성공시 이동할 URL 설정
//                                .logoutSuccessUrl("/users/login")
//                );

        return http.build();
    }

//    @Bean
    // 사용자 관리를 위한 인터페이스 구현체 Bean
    public UserDetailsManager userDetailsManager(
            PasswordEncoder passwordEncoder
    ) {
        // 임시 User
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder.encode("password"))
                .build();
        // Spring 에서 미리 만들어놓은 사용자 인증 서비스
        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    // 비밀번호 암호화를 위한 Bean
    public PasswordEncoder passwordEncoder(){
        // 기본적으로 사용자 비밀번호는 해독가능한 형태로 데이터베이스에
        // 저장되면 안된다. 그래서 기본적으로 비밀번호를 단방향 암호화 하는
        // 인코더를 사용한다.
        return new BCryptPasswordEncoder();
    }
}
