package com.LiveNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class LiveNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveNotificationApplication.class, args);
	}

}
