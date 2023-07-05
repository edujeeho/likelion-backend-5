package com.example.client.client;

import com.example.client.dto.BeerGetDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Primary
public class BeerWebClient implements BeerClient {
    public BeerGetDto getBeer() {
        WebClient webClient = WebClient.builder().build();
        String url = "https://random-data-api.com/api/v2/beers";

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(BeerGetDto.class)
                .block();
    }
}
