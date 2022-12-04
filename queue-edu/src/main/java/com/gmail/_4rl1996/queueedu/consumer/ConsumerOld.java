package com.gmail._4rl1996.queueedu.consumer;

import com.gmail._4rl1996.queueedu.message.TestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ConsumerOld {

    @RabbitListener(queues = "${rabbit.properties.queueName}", autoStartup = "${autostartup}")
    public void onMessage(Message<TestMessage> message) {
        TestMessage payload = message.getPayload();
        System.out.println("\n\nMessage was received by ConsumerOld from queue-edu service.\nMessageHeaders are:\n" +
                message.getHeaders() +
                "\nMessage Payload is:\n" +
                payload);
    }
}
