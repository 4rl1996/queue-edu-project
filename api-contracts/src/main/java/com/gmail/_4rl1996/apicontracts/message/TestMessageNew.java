package com.gmail._4rl1996.apicontracts.message;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class TestMessageNew {

    private AtomicLong messageCounter = new AtomicLong(0);

    private static final String message = "The number of new message is ";

    private String creationTime;

    @Override
    public String toString() {
        return message +
                messageCounter +
                ". " +
                "New message was created at " +
                creationTime;
    }

}
