package com.gmail._4rl1996.queueedu.consumer;

import com.gmail._4rl1996.message.TestMessageNew;
import com.gmail._4rl1996.queueedu.config.properties.ApplicationProperties;
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
public class DlqConsumerNew {

    private final ApplicationProperties applicationProperties;

//    @RabbitListener(bindings =
//    @QueueBinding(
//            value = @Queue(name = "${rabbit.properties.dlqEduQueueNewName}"),
//            exchange = @Exchange(value = "${rabbit.properties.fanoutExchangeName}", type = ExchangeTypes.FANOUT)
//    ))
//    public void onMessage(Message<TestMessageNew> message) {
//
//        TestMessageNew payload = message.getPayload();
//        System.out.println("\n\nMessage was received by DlqConsumerNew from queue-edu service, queue = " + applicationProperties.getDlqEduQueueName() +
//                ".\nMessageHeaders are:\n" +
//                message.getHeaders() +
//                "\nMessage Payload is:\n" +
//                payload);
//    }
}
