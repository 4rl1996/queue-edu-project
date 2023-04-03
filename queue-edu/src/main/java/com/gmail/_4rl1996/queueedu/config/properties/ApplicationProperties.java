package com.gmail._4rl1996.queueedu.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbit.properties")
public class ApplicationProperties {
    private String queueEduName;
    private String queueEduNewName;
    private String dlqEduQueueName;
    private String dlqEduQueueKeyName;
    private String dlqEduExchangeName;
    private String dlqEduExchangeNewName;
    private String dlqEduQueueNewName;
    private String dlqEduQueueKeyNewName;
    private String fanoutExchangeName;
    private String directExchangeName;
    private String routingKey;
}
