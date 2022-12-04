package com.gmail._4rl1996.queueedu.producer;

import com.gmail._4rl1996.queueedu.message.TestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String queueName, TestMessage testMessage) {
        rabbitTemplate.convertAndSend(queueName, testMessage);
    }
}
