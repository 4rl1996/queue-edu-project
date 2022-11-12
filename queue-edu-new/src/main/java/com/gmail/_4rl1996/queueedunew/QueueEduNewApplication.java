package com.gmail._4rl1996.queueedunew;

import com.gmail._4rl1996.queueedunew.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(value = {ApplicationProperties.class})
@EnableScheduling
public class QueueEduNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueueEduNewApplication.class, args);
    }

}
