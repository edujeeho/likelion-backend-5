package com.example.jpa;


import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {
    // Controller, Service, Repository 가 아닌
    // 평범한 Bean 객체
    // 외부 API 사용, 공유된 기능 개발, 그냥 IoC 등록하고 싶은 객체

    // 필요로 하는 설정
    private final AppConfigData configData;
    private final Gson gson;
    public AppComponent(AppConfigData configData, Gson gson) {
        this.configData = configData;
        this.gson = gson;
    }
    // 외부 API를 사용하는 메소드
    public void useApi() {
        // send request
    }
}
