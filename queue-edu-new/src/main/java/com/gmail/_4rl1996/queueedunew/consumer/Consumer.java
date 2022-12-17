package com.gmail._4rl1996.queueedunew.consumer;

import com.gmail._4rl1996.message.TestMessageNew;
import com.gmail._4rl1996.queueedunew.config.properties.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class Consumer {

    private final ApplicationProperties applicationProperties;

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(name = "${rabbit.properties.queueName}"),
            exchange = @Exchange(value = "${rabbit.properties.exchangeName}", type = ExchangeTypes.FANOUT)
    ))
    public void onMessage(Message<TestMessageNew> message) {

        TestMessageNew payload = message.getPayload();

        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            throw new RuntimeException(String.format("Runtime exception at Consumer from from queue-edu-new service for message with UUID = %s", payload.getId()));
        }

        System.out.println("\n\nMessage was received by Consumer from queue-edu-new service, queue = " + applicationProperties.getQueueName() +
                ".\nMessageHeaders are:\n" +
                message.getHeaders() +
                "\nMessage Payload is:\n" +
                payload);
    }
}
