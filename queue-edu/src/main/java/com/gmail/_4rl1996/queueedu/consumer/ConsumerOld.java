package com.gmail._4rl1996.queueedu.consumer;

import com.gmail._4rl1996.queueedu.config.properties.ApplicationProperties;
import com.gmail._4rl1996.queueedu.message.TestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@RequiredArgsConstructor
public class ConsumerOld {

    private final ApplicationProperties applicationProperties;

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(name = "${rabbit.properties.queueEduName}"
            ),
            exchange = @Exchange(name = "${rabbit.properties.directExchangeName}"),
            key = "${rabbit.properties.routingKey}")
    )
    public void onMessage(Message<TestMessage> message) {

        TestMessage payload = message.getPayload();

        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            throw new RuntimeException(String.format("Runtime exception at ConsumerOld from queue-edu-service for message with UUID = %s", payload.getId()));
        }

        System.out.println("\n\nMessage was received by ConsumerOld from queue-edu service, queue = " + applicationProperties.getQueueEduName() +
                ".\nMessageHeaders are:\n" +
                message.getHeaders() +
                "\nMessage Payload is:\n" +
                payload);
    }
}
