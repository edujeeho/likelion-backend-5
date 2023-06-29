package com.example.contents;

import com.example.contents.dto.UserDto;
import com.example.contents.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("UserDto로 UserEntity 생성")
    public void testCreateUser() {
        // given
        // 생성 할 UserEntity
        String username = "jeeho.dev";
        UserEntity userEntityIn = new UserEntity();
        userEntityIn.setUsername(username);

        // 생성 될 UserEntity
        Long userId = 1L;
        UserEntity userEntityOut = new UserEntity();
        userEntityOut.setId(userId);
        userEntityOut.setUsername(username);
        // Mock 객체(가짜 객체)의 행동 정의
        when(userRepository.save(userEntityIn))
                .thenReturn(userEntityOut);

        // when
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        UserDto result = userService.createUser(userDto);

        // then
        assertEquals(userId, result.getId());
        assertEquals(username, result.getUsername());
    }

    @Test
    @DisplayName("username으로 UserDto 반환")
    public void testReadUserByUsername() {
        // given
        String username = "jeeho.dev";
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername(username);
        when(userRepository.findByUsername(username))
                .thenReturn(Optional.of(user));
        // when
        UserDto result = userService.readUserByUsername(username);

        // then
        assertEquals(username, result.getUsername());
    }

    @Test
    @DisplayName("UserDto를 이용해 UserEntity 수정")
    public void testUpdateUser() {
        // given
        Long userId = 1L;
        String username = "jeeho.dev";
        String bio = "Developer Developing Developers";
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setUsername(username);
        when(userRepository.findById(user.getId()))
                .thenReturn(Optional.of(user));
        doAnswer(returnsFirstArg())
                .when(userRepository)
                .save(any());

        // when
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setBio(bio);
        UserDto result = userService.updateUser(userId, userDto);

        // then
        assertEquals(userId, result.getId());
        assertEquals(username, result.getUsername());
        assertEquals(bio, result.getBio());
    }

    @Test
    @DisplayName("UserEntity에 이미지 추가")
    public void testUpdateUserAvatar() {
        // given
        Long userId = 1L;
        String username = "jeeho.dev";
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setUsername(username);
        when(userRepository.findById(user.getId()))
                .thenReturn(Optional.of(user));
        doAnswer(returnsFirstArg())
                .when(userRepository)
                .save(any());

        // when
        MultipartFile mockFile = new MockMultipartFile(
                "image",
                "test.png",
                MediaType.IMAGE_PNG_VALUE,
                "test".getBytes()
        );
        UserDto userDto = userService.updateUserAvatar(userId, mockFile);

        // then
        assertEquals(userId, userDto.getId());
        assertEquals(String.format("/static/%d/profile.png", userId), userDto.getAvatar());
    }
}
