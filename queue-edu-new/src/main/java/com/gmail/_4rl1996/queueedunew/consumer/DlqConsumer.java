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

@Service
@RequiredArgsConstructor
public class DlqConsumer {

    private final ApplicationProperties applicationProperties;

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(name = "${rabbit.properties.dlqEduQueueName}"),
            exchange = @Exchange(name = "${rabbit.properties.dlqEduExchangeName}")
    ))
    public void onMessage(Message<TestMessageNew> message) {

        TestMessageNew payload = message.getPayload();
        System.out.println("\n\nMessage was received by DlqConsumer from  queue-edu-new service, queue = " + applicationProperties.getDlqEduQueueName() +
                ".\nMessageHeaders are:\n" +
                message.getHeaders() +
                "\nMessage Payload is:\n" +
                payload);
    }
}
