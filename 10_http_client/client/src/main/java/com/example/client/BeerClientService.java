package com.example.client;

import com.example.client.dto.BeerGetDto;
import com.example.client.dto.BeerPostDto;
import com.example.client.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class BeerClientService {
    public void getBeer() {
        WebClient webClient = WebClient.builder().build();
        // WebClient는 Builder 패턴처럼 사용

        String url = "https://random-data-api.com/api/v2/beers?size=10";
        // 어떤 HTTP 메소드로 요청을 보낼지를 get() post() 메소드 등으로 결정
        // 만일 다른 메소드를 쓰고 싶다면, method()
        BeerGetDto response = webClient.get()  // webClient.method(HttpMethod.GET)
                .uri(url)  // 요청 경로 설정
                .header("x-test", "header")  // 요청 헤더 추가
                // body도 메소드에 따라 추가
                .retrieve()  // 여기 전까지는 요청을 정의한 부분
                // 이제부터 정의하는건 응답을 어떻게 처리할 것인지
                .bodyToMono(BeerGetDto.class)  // 응답이 한번 돌아올것이며, 그 응답의 body를 String으로 해석
                .block();  // 동기식으로 처리하겠다.
        log.info(response.toString());
    }

    public void postBeer() {
        WebClient webClient = WebClient.builder().build();
        String url = "http://localhost:8081/give-me-beer";

        BeerPostDto dto = new BeerPostDto();
        // post 요청 시작
        MessageDto responseBody = webClient.post()
                .uri(url)  // url 정의
                .bodyValue(dto)  // requestBody 정의
                .retrieve()  // 응답 정의 시작
                .bodyToMono(MessageDto.class)  // 응답 데이터 정의
                .block();  // 동기식 처리

        log.info(responseBody.toString());
    }

    public void postBeer204(){
        WebClient webClient = WebClient.builder().build();
        String url = "http://localhost:8081/give-me-beer-204";

        BeerPostDto dto = new BeerPostDto();
        ResponseEntity<Void> response = webClient.post()
                .uri(url)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()  // 응답 Body가 없을 경우 사용
                .block();

        log.info(response.getStatusCode().toString());
    }
}
