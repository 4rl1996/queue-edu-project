package com.gmail._4rl1996.queueedu.config;

import com.gmail._4rl1996.apicontracts.message.TestMessage;
import com.gmail._4rl1996.apicontracts.message.TestMessageNew;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public TestMessage testMessage() {
        return new TestMessage();
    }

    @Bean
    public TestMessageNew testMessageNew() {
        return new TestMessageNew();
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
