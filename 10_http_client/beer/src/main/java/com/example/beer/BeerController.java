package com.example.beer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BeerController {
    @PostMapping("/give-me-beer")
    public MessageDto giveMeBeer(@RequestBody BeerDto beerDto) {
        log.info(beerDto.toString());
        log.info("꺼어어억");
        return new MessageDto("꺼어어억");
    }

    @PostMapping("/give-me-beer-204")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void giveMeBeer204(@RequestBody BeerDto beerDto) {
        log.info(beerDto.toString());
        log.info("꺼어어억");
    }
}
