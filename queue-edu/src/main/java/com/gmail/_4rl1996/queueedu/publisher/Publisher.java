package com.gmail._4rl1996.queueedu.publisher;

import com.gmail._4rl1996.apicontracts.message.TestMessage;
import com.gmail._4rl1996.queueedu.config.properties.ApplicationProperties;
import com.gmail._4rl1996.queueedu.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class Publisher {

    private final ApplicationProperties applicationProperties;
    private final Producer producer;
    private final TestMessage testMessage;

    @Scheduled(fixedRate = 1000)
    void publishMessage() {
        if (applicationProperties.isEnablePublishing()) {
            testMessage.getMessageCounter().incrementAndGet();
            testMessage.setCreationTime(Instant.now().toString());
            producer.sendMessage(applicationProperties.getQueueName(), testMessage);
        }
    }
}
