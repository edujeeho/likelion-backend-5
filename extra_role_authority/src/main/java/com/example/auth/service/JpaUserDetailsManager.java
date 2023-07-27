package com.example.auth.service;

import com.example.auth.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Slf4j
@Service
// UserDetailsManager의 구현체로 만들면, Spring Security Filter에서 사용자 정보 회수에 활요할 수 있다.
public class JpaUserDetailsManager implements UserDetailsManager {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public JpaUserDetailsManager(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            AuthorityRepository authorityRepository
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

        // READ 권한 생성
        Authority readAuthority = new Authority();
        readAuthority.setName("READ");
        readAuthority = authorityRepository.save(readAuthority);

        // WRITE 권한 생성
        Authority writeAuthority = new Authority();
        writeAuthority.setName("WRITE");
        writeAuthority = authorityRepository.save(writeAuthority);

        // USER 역할 생성 (READ)
        Role userRole = new Role();
        userRole.setName("USER");
        userRole.getAuthorities().add(readAuthority);
        userRole = roleRepository.save(userRole);

        // ADMIN 역할 생성 (READ, WRITE)
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        adminRole.getAuthorities().add(readAuthority);
        adminRole.getAuthorities().add(writeAuthority);
        adminRole = roleRepository.save(adminRole);

        // USER 역할 사용자 생성
        UserEntity user = new UserEntity();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("asdf"));
        user.getRoles().add(userRole);
        userRepository.save(user);

        // ADMIN 역할 사용자 생성
        UserEntity admin = new UserEntity();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("asdf"));
        admin.getRoles().add(adminRole);
        userRepository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser
                = userRepository.findByUsername(username);
        if (optionalUser.isEmpty())
            throw new UsernameNotFoundException(username);

        return CustomUserDetails.fromEntity(optionalUser.get());
    }

    @Override
    public void createUser(UserDetails user) {
        log.info("try create user: {}", user.getUsername());
        if (this.userExists(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        try {
            userRepository.save(((CustomUserDetails) user).newEntity());
        } catch (ClassCastException e) {
            log.error("failed to cast to {}", CustomUserDetails.class);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    // 계정이름을 가진 사용자가 존재하는지 확인하는 메소드 (선택)
    public boolean userExists(String username) {
        log.info("check if user: {} exists", username);
        return this.userRepository.existsByUsername(username);
    }

    // 얘네는 나중에 해보세요...
    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

}
