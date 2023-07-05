package com.example.client;

import com.example.client.dto.BeerGetDto;
import com.example.client.dto.BeerPostDto;
import com.example.client.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
//@RequiredArgsConstructor
public class BeerRestService {
//    private final RestTemplate restTemplate;

    // getForObject -> 다른거 필요 없고, 응답 Body 만 있으면 될때
    public void getBeerObject() {
        // RestTemplate: Spring 에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-data-api.com/api/v2/beers";

//        // RestTemplate 으로 GET 요청
//        String responseBody = restTemplate.getForObject(url, String.class);
//        log.info(responseBody);

        // @RequestBody, @ResponseBody => JSON -> DTO
        BeerGetDto responseBody
                = restTemplate.getForObject(url, BeerGetDto.class);
        log.info(responseBody.toString());
    }

    // STATUS LINE
    // RESPONSE HEADER
    // RESPONSE BODY
    // getForEntity: HTTP 응답 전체 확인
    public void getBeerEntity() {
        // RestTemplate: Spring 에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-data-api.com/api/v2/beers";

        // RestController
        ResponseEntity<BeerGetDto> response =
                restTemplate.getForEntity(url, BeerGetDto.class);
        log.info(response.getStatusCode().toString());
        log.info(response.getHeaders().toString());
        log.info(response.getBody().toString());
    }

    // postForObject
    public void postBeerObject() {
        // RestTemplate: Spring 에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/give-me-beer";

        BeerPostDto dto = new BeerPostDto();
        dto.setName("Stella Artois");
        dto.setCc(2000L);
        dto.setAlcohol(5.0);

        // post 요청을 보낼 때 requestBody를 같이 전달
        MessageDto responseBody = restTemplate.postForObject(
                url,  // 요청 URL
                dto,  // request Body
                MessageDto.class  // 응답 해석 타입
        );
        log.info(responseBody.toString());

        // 응답 Body 없이 응답하는 URL
        url = "http://localhost:8081/give-me-beer-204";
        ResponseEntity<Void> response = restTemplate.postForEntity(
                url,
                dto,
                Void.class  // void 의 클래스 (객체화 불가)
        );
        log.info(response.getStatusCode().toString());
//        restTemplate.exchange(
//                url,
//                HttpMethod.POST,
//                new HttpEntity<>(dto),
//                Void.class
//        );
    }

    // HttpEntity와 restTemplate.exchange()
    public void exchange() {
        RestTemplate restTemplate = new RestTemplate();
        String getBeerUrl = "https://random-data-api.com/api/v2/beers";
        // exchange(URL, METHOD, BODY, RESPONSE BODY TYPE)
        ResponseEntity<BeerGetDto> getResponse = restTemplate.exchange(
                getBeerUrl,
                HttpMethod.GET,
                null,
                BeerGetDto.class
        );
        if (!(getResponse.getStatusCode().is2xxSuccessful() && getResponse.hasBody()))
            throw new ResponseStatusException(getResponse.getStatusCode());

        BeerGetDto responseBody = getResponse.getBody();

        BeerPostDto requestBody = new BeerPostDto();
        requestBody.setName(responseBody.getName());
        requestBody.setAlcohol(Double.parseDouble(responseBody.getAlcohol().replace("%", "")));
        requestBody.setCc(1000L);

        String postBeerUrl = "http://localhost:8081/give-me-beer";
        // HttpEntity: Header와 Body를 포함한 요청 또는 응답을 나타내는 기초 클래스
        // ResponseEntity: HttpEntity를 상속받은 HTTP 응답을 나타내는 클래스
        HttpEntity<BeerPostDto> request = new HttpEntity<>(
                // BODY 설정
                requestBody,
                // HEADER 설정
                new HttpHeaders()
        );
        ResponseEntity<MessageDto> postResponse = restTemplate.exchange(
                postBeerUrl,
                HttpMethod.POST,
                request,
                MessageDto.class
        );

        log.info(postResponse.getStatusCode().toString());
    }
}
