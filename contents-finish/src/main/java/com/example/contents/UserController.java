package com.example.contents;

import com.example.contents.dto.ResponseDto;
import com.example.contents.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    // POST /users
    // 새 사용자 생성
    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        return service.createUser(userDto);
    }

    // GET /users/{username}
    // 사용자 정보 조회
    @GetMapping("/{username}")
    public UserDto read(@PathVariable("username") String username) {
        return service.readUserByUsername(username);
    }

    // PUT /users/{id}
    // 사용자 정보 수정
    @PutMapping("/{id}")
    public UserDto update(
            @PathVariable("id") Long id,
            @RequestBody UserDto userDto
    ) {
        return service.updateUser(id, userDto);
    }

    // PUT /users/{id}/avatar
    // 사용자 프로필 이미지 설정
    @PutMapping(
            value = "/{id}/avatar",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public UserDto avatar(
            @PathVariable("id") Long id,
            @RequestParam("image") MultipartFile avatarImage
    ) {
        return service.updateUserAvatar(id, avatarImage);
    }

//    // ExceptionHandler: Controller 내부에서 지정된 예외가 발생했을 때
//    // 실행하는 메소드에 붙이는 어노테이션
//    @ExceptionHandler(IllegalStateException.class)
//    public ResponseDto handleIllegalState(IllegalStateException exception) {
//        log.error(exception.getMessage());
//        ResponseDto response = new ResponseDto();
//        response.setMessage("이러저러한 이유로 에러가 발생했습니다.");
//        return response;
//    }
}









