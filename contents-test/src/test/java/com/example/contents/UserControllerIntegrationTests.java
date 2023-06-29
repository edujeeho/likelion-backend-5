package com.example.contents;

import com.example.contents.dto.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = ContentsApplication.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("UserEntity 생성 통합 테스트")
    public void whenPostUserDto_thenReturnJson() throws Exception {
        String username = "jeeho.dev";
        String email = "jeeho.dev@gmail.com";
        String bio = "Developer Developing Developers";
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setEmail(email);
        userDto.setBio(bio);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(userDto)))
                .andExpectAll(
                        status().is2xxSuccessful(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.username", is(username)),
                        jsonPath("$.email", is(email)),
                        jsonPath("$.bio", is(bio))
                );

        assertTrue(userRepository.existsByUsername(username));
    }
}


