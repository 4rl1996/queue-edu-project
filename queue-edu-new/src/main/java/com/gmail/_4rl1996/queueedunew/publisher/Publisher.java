package com.gmail._4rl1996.queueedunew.publisher;

import com.gmail._4rl1996.message.TestMessageNew;
import com.gmail._4rl1996.queueedunew.config.properties.ApplicationProperties;
import com.gmail._4rl1996.queueedunew.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Publisher {

    private final ApplicationProperties applicationProperties;
    private final Producer producer;

    @Scheduled(fixedRate = 1000)
    void publishMessage() {
        TestMessageNew testMessage = new TestMessageNew();
        testMessage.setCreationTime(Instant.now().toString());
        testMessage.setId(UUID.randomUUID());
        producer.sendMessage(applicationProperties.getExchangeName(), testMessage);
    }

}