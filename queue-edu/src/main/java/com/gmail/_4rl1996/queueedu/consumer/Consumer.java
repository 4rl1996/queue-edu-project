package com.gmail._4rl1996.queueedu.consumer;

import com.gmail._4rl1996.apicontracts.message.TestMessageNew;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Service
public class Consumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "${rabbit.properties.queueName}"),
            exchange = @Exchange(value = "${rabbit.properties.exchangeName}", type = ExchangeTypes.FANOUT)))
public void onMessage(Message<TestMessageNew> message) {
        TestMessageNew payload = message.getPayload();
        System.out.println("\n\nMessage was received.\nMessageHeaders are:\n" +
                message.getHeaders() +
                "\nMessage Payload is:\n" +
                payload);
    }
}
