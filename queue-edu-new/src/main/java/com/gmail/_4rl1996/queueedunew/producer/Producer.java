package com.gmail._4rl1996.queueedunew.producer;

import com.gmail._4rl1996.queueedunew.message.TestMessageNew;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String exchange, TestMessageNew testMessage) {
        rabbitTemplate.convertAndSend(exchange, "", testMessage);
    }
}
