package com.example.auth;

import com.example.auth.entity.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller  // 로그인 페이지를 보여줄려고
@RequestMapping("/users")
public class UserController {

    // 1. login 페이지로 온다.
    // 2. login 페이지에 아이디 비밀번호를 입력한다.
    // 3. 성공하면 my-profile 로 이동한다.

    // 로그인 페이지를 위한 GetMapping
    @GetMapping("/login")
    public String loginForm() {
        return "login-form";
    }

    // 로그인 성공 후 로그인 여부를 판단하기 위한 GetMapping
    @GetMapping("/my-profile")
    public String myProfile(
            Authentication authentication
    ) {
        log.info(authentication.getName());
        log.info(
                ((CustomUserDetails) authentication.getPrincipal())
                        .getEmail());
        log.info(SecurityContextHolder.getContext().getAuthentication().getName());
        return "my-profile";
    }

    // 1. 사용자가 register 페이지로 온다.
    // 2. 사용자가 register 페이지에 ID, 비밀번호, 비밀번호 확인을 입력
    // 3. register 페이지에서 /users/register 로 POST 요청
    // 4. UserDetailsManager 에 새로운 사용자 정보 추가

    @GetMapping("/register")
    public String registerForm() {
        return "register-form";
    }

    // 어떻게 사용자를 관리하는지는
    // interface 기반으로 의존성 주입
    private final UserDetailsManager manager;
    private final PasswordEncoder passwordEncoder;


    public UserController(
            UserDetailsManager manager,
            PasswordEncoder passwordEncoder
    ) {
        this.manager = manager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String registerPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password-check") String passwordCheck
    ) {
        if (password.equals(passwordCheck)) {
            UserDetails details = CustomUserDetails
                    .builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .build();
            log.info("password match!");
            manager.createUser(details);
            return "redirect:/users/login";
        }
        log.warn("password does not match...");
        return "redirect:/users/register?error";
    }
}
