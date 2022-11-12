package com.gmail._4rl1996.queueedu;

import com.gmail._4rl1996.queueedu.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(value = {ApplicationProperties.class})
@EnableScheduling
public class QueueEduApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueEduApplication.class, args);
	}
}
