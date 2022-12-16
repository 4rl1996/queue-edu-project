package com.gmail._4rl1996.queueedu.message;

import lombok.Data;

import java.util.UUID;

@Data
public class TestMessage {

    private  UUID id;
    private static final String message = "Message id is ";
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