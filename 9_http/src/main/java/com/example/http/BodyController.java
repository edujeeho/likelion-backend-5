package com.example.http;

import com.example.http.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@Controller
@RestController
public class BodyController {
    // `/body`로 ArticleDto를 표현한 JSON과 함께
    // 요청이 들어왔을 때,
    // ResponseDto를 표현한 JSON을 포함해 응답하는 메소드
    @PostMapping("/body")
//    @ResponseBody
    public ResponseDto body(
            @RequestBody
            ArticleDto dto
    ) {
        log.info("POST /body " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    @PostMapping("/body-2")
//    @ResponseBody
    public ResponseDto body2(
            @RequestBody
            WriterDto dto
    ) {
        log.info("POST /body-2 " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    @PostMapping("/body-3")
    public ResponseDto body3(
            @RequestBody
            ArticleWithCommentsDto dto
    ) {
        log.info("POST /body-3 " + dto.toString());
        return new ResponseDto();
    }

    @PostMapping("/body-4")
    public String body4(
            @RequestBody
            ArticleComplexDto dto
    ) {
        log.info("POST /body-4 " + dto.toString());
        return "index";
//        return new ResponseDto();
    }

    // @ResponseBody는 요청의 HTTP Body만 설정
    // Header를 추가하거나
    // Status code를 고르고 싶을 때
    // ResponseEntity<T>
    @PostMapping("/entity")
    public ResponseEntity<ResponseDto> entity(
            @RequestBody
            ArticleDto dto
    ) {
        log.info("POST /entity " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        // 상태코드 지정해서 ResponseEntity 객체 그냥 쓰기
        ResponseEntity<ResponseDto> responseEntity
                = new ResponseEntity<>(
                response, HttpStatus.INTERNAL_SERVER_ERROR);
//        return responseEntity;

        // 커스텀 헤더 만들고 함께 응답하기
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-likelion-custom", "Hello World!");
//        return new ResponseEntity<>(
//                response, headers, HttpStatus.ACCEPTED
//        );

        // Builder 사용하기
        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .ok()
//                .badRequest()
                .accepted()
                .header("x-likelion-one", "1")
                .headers(headers)
                .body(response);
    }
}
