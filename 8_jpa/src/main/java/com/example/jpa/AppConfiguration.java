package com.example.jpa;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Spring을 활용하는데 필요한 다양한 설정을 담고 있는 용도
@Configuration
public class AppConfiguration {

    @Bean  // Concrete Class가 아닌 메소드의 반환값을 Bean 객체로 등록할 때 사용
    public AppConfigData connectionUrl() {
        // 이 메소드의 결과(반환값)를 Bean 객체로 등록
        if (true /* 현재 나의 상황에 따라서 다른 URL을 지급하는 코드 */)
            return new AppConfigData("main-url");
        else return new AppConfigData("backup-url");
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
