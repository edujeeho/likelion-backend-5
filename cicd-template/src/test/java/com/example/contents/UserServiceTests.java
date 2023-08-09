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
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // UserDto(id==null)를 입력받아 UserDto(id!=null)를 반환
    @Test
    @DisplayName("UserDto로 createUser")
    public void testCreateUser() {
        // given
        // 1. UserRepository 가 전달받을 UserEntity 정의
        String username = "jeeho.dev";
        UserEntity userEntityIn = new UserEntity();
        userEntityIn.setUsername(username);

        // 2. UserRepository 가 반환할 UserEntity 정의
        Long userId = 1L;
        UserEntity userEntityOut = new UserEntity();
        userEntityOut.setId(userId);
        userEntityOut.setUsername(username);

        // 3. UserRepository의 기능을 따라하도록 설정
        // userRepository는 아래와 같이 기능할것이다 라고 가정
        when(userRepository.save(userEntityIn))
                .thenReturn(userEntityOut);
        when(userRepository.existsByUsername(username))
                .thenReturn(false);

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
