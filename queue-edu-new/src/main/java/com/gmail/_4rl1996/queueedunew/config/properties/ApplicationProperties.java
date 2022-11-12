package com.gmail._4rl1996.queueedunew.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbit.properties")
public class ApplicationProperties {
    private String exchangeName;
}
