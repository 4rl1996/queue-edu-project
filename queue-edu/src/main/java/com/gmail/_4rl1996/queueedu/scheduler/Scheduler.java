package com.gmail._4rl1996.queueedu.scheduler;

import com.gmail._4rl1996.queueedu.config.properties.ApplicationProperties;
import com.gmail._4rl1996.queueedu.message.TestMessage;
import com.gmail._4rl1996.queueedu.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Scheduler {

    private final ApplicationProperties applicationProperties;
    private final Producer producer;

    //    @Scheduled(fixedRate = 1000)
    void publishMessage() {
        TestMessage testMessage = new TestMessage();
        testMessage.setCreationTime(Instant.now().toString());
        testMessage.setId(UUID.randomUUID());
        producer.sendMessage(applicationProperties.getQueueName(), testMessage);
    }
}
