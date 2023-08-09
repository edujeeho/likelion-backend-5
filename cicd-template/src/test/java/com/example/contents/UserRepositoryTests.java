package com.example.contents;

import com.example.contents.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("새 UserEntity 를 데이터베이스에 추가 성공")
    public void testSaveNew() {
        // given: 테스트가 진행되기 위한 전제 조건을 준비하는 구간
        // 새로운 UserEntity 준비
        String username = "jeeho.dev";
        UserEntity user = new UserEntity();
        user.setUsername(username);

        // when: 테스트 하고싶은 실제 기능을 작성하는 구간
        user = userRepository.save(user);

        // then: 실행한 결과가 기대한 것과 같은지를 검증하는 구간
        // 1. 새로 반환받은 user의 id는 null이 아님
        assertNotNull(user.getId());
        // 2. 새로 반환받은 user의 username은 우리가 넣었던 username과 동일
        assertEquals(username, user.getUsername());
    }

    @Test
    @DisplayName("새 UserEntity 를 데이터베이스에 추가 실패")
    public void testSaveNewFail() {
        // given: username을 가지고 UserEntity를 먼저 save
        String username = "jeeho.dev";
        UserEntity userGiven = new UserEntity();
        userGiven.setUsername(username);
        userRepository.save(userGiven);

        // when: 같은 username을 가진 새 UserEntity save 시도
        UserEntity user = new UserEntity();
        user.setUsername(username);

        // when-then: 예외 발생
        assertThrows(Exception.class, () -> userRepository.save(user));
    }

    @Test
    @DisplayName("username으로 UserEntity 찾기")
    public void testFindByUsername() {
        // given: 검색할 UserEntity 미리 생성
        String username = "jeeho.dev";
        UserEntity userGiven = new UserEntity();
        userGiven.setUsername(username);
        userRepository.save(userGiven);

        // when: userRepository.findByUsername()
        Optional<UserEntity> optionalUser
                = userRepository.findByUsername(username);

        // then: Optional.isPresent(), username == username
        assertTrue(optionalUser.isPresent());
        assertEquals(username, optionalUser.get().getUsername());
    }

    @Test
    @DisplayName("username으로 찾기 실패")
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
    @DisplayName("id로 UserEntity 삭제")
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
