package com.example.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
    @Bean
    public Queue queue(){
        return new Queue(
                // 이름: Producer와 Consumer가 같은 Queue를 사용하기 위해
                //     작성하는 식별자
                "boot.amqp.worker-queue",
                // durable: 서버(Producer)가 종료된 후에도 Queue가 유지될지
                true,
                // exclusive: 지금 이 서버만 큐를 사용할 수 있는지
                false,
                // autoDelete: 사용되고 있지 않은 큐를 자동으로 삭제할 것인지
                true
        );
    }
}
