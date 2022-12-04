package com.gmail._4rl1996.queueedunew.message;

import lombok.Data;

import java.util.UUID;

@Data
public class TestMessageNew {

    private UUID id;
    private static final String message = "TestMessageNew id is ";
    private String creationTime;

    @Override
    public String toString() {
        return message +
                id +
                ". " +
                "Message was created at " +
                creationTime;
    }
}