package com.example.http;

import com.example.http.dto.ArticleDto;
import com.example.http.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class BodyController {
    // `/body`로 요청이 들어왔을 때,
    // ResponseDto 데이터를 표현한 JSON 응답을 반환하는 메소드
    @PostMapping("/body")
    // HTTP 응답의 Body임을 나타내는 어노테이션
    public @ResponseBody ResponseDto body(
            @RequestBody ArticleDto requestDto
    ) {
        log.info(requestDto.toString());
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("success");
        return response;
    }
}
