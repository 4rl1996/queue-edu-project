package com.gmail._4rl1996.queueedunew.publisher;

import com.gmail._4rl1996.apicontracts.message.TestMessageNew;
import com.gmail._4rl1996.queueedunew.config.properties.ApplicationProperties;
import com.gmail._4rl1996.queueedunew.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class Publisher {

    private final ApplicationProperties applicationProperties;
    private final Producer producer;
    private final TestMessageNew testMessage;

    @Scheduled(fixedRate = 1000)
    void publishMessage() {
        testMessage.getMessageCounter().incrementAndGet();
        testMessage.setCreationTime(Instant.now().toString());
        producer.sendMessage(applicationProperties.getExchangeName(), testMessage);
    }

}