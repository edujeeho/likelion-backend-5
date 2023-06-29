package com.example.contents;

import com.example.contents.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("새 user 생성")
    public void testSaveNew() {
        // given
        String username = "jeeho.dev";
        UserEntity user = new UserEntity();
        user.setUsername(username);

        // when
        user = userRepository.save(user);

        // then
        assertNotNull(user.getId());
        assertEquals(username, user.getUsername());
    }

    @Test
    @DisplayName("새 user 생성 실패")
    public void testSaveNewFail() {
        // given
        String username = "jeeho.dev";
        UserEntity userGiven = new UserEntity();
        userGiven.setUsername(username);
        userGiven = userRepository.save(userGiven);

        // when
        UserEntity user = new UserEntity();
        user.setUsername(username);

        // when-then
        assertThrows(Exception.class, () -> userRepository.save(user));
    }

    @Test
    @DisplayName("username으로 user 찾기")
    public void testFindByUsernameSuccess() {
        // given
        String username = "jeeho.dev";
        UserEntity userGiven = new UserEntity();
        userGiven.setUsername(username);

        userRepository.save(userGiven);

        // when
        Optional<UserEntity> user = userRepository.findByUsername(username);

        // then
        assertTrue(user.isPresent());
        assertEquals(user.get().getUsername(), username);
    }

    @Test
    @DisplayName("username으로 user 찾기 실패")
    public void testFindByUsernameFail() {
        // given
        String username = "jeeho.dev";
        UserEntity userGiven = new UserEntity();
        userGiven.setUsername(username);

        userRepository.save(userGiven);

        // when
        Optional<UserEntity> user = userRepository.findByUsername("not_found");

        // then
        assertTrue(user.isEmpty());
    }

    @Test
    @DisplayName("username으로 user 존재 유무 판단")
    public void testExistsByUsername() {
        // given
        String usernameExists = "jeeho.dev";
        String usernameExistsNot = "not_found";
        UserEntity userGiven = new UserEntity();
        userGiven.setUsername(usernameExists);
        userRepository.save(userGiven);

        // when
        Boolean exists = userRepository.existsByUsername(usernameExists);
        Boolean existsNot = userRepository.existsByUsername(usernameExistsNot);

        // then
        assertTrue(exists);
        assertFalse(existsNot);
    }

    @Test
    @DisplayName("id로 user 삭제")
    public void testDeleteById() {
        // given
        String username = "target";
        UserEntity target = new UserEntity();
        target.setUsername(username);
        Long id = userRepository.save(target).getId();

        // when
        userRepository.deleteById(id);

        // then
        assertFalse(userRepository.existsByUsername(username));
    }
}
