package com.example.contents;

import com.example.contents.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class UserControllerTests {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    @DisplayName("UserDto 보내면 ID가 채워져 UserDto가 응답됨")
    public void testCreate() throws Exception {
        // given
        Long userId = 1L;
        String username = "jeeho.dev";
        UserDto requestDto = new UserDto();
        requestDto.setUsername(username);
        UserDto responseDto = new UserDto();
        responseDto.setUsername(requestDto.getUsername());
        responseDto.setId(userId);
        when(userService.createUser(requestDto))
                .thenReturn(responseDto);

        // when
        mockMvc.perform(post("/users")
                        .content(JsonUtil.toJson(requestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().is2xxSuccessful(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.username", is(username)),
                        jsonPath("$.id", notNullValue())
                );
    }
}
