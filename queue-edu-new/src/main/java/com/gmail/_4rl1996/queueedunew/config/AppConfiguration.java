package com.gmail._4rl1996.queueedunew.config;

import com.gmail._4rl1996.apicontracts.message.TestMessageNew;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

    @Bean
    public TestMessageNew testMessageNew() {
        return new TestMessageNew();
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
