package com.example.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeerRestServiceTests {
    @Autowired
    private BeerRestService service;

    @Test
    public void testGetBeerObject() {
        service.getBeerObject();
    }

    @Test
    public void testGetBeerEntity() {
        service.getBeerEntity();
    }

    @Test
    public void testPostBeerObject() {
        service.postBeerObject();
    }

    @Test
    public void testExchange() {
        service.exchange();
    }
}
