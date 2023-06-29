package com.example.contents;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
public class ContentsApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ContentsApplication.class, args);
		Runnable logRunnable = () -> log.info("log test {}", LocalDateTime.now());
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(logRunnable, 0, 500, TimeUnit.MILLISECONDS);
	}

}
