package com.example.client.service;

import com.example.client.client.BeerClient;
import com.example.client.dto.BeerGetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeerService {
    // Service는 맥주정보를 어떻게 가져왔는지 중요하지 않다.
//    private final BeerRestClient client;
//    private final BeerWebClient client;
    private final BeerClient client;

    public BeerService(
//            BeerWebClient client
            @Qualifier("beerRestClient")
            BeerClient client

    ) {
        this.client = client;
    }

    public void drinkBeer() {
        log.info("order beer");
        BeerGetDto result = client.getBeer();
        // 핵심은 맥주 정보
        // 맥주 정보를 받아오는 방법은 비즈니스 로직에서 벗어났다
        // 할수 있지 않을까?
        log.info("{}는 맛있다", result.getName());
    }
}
