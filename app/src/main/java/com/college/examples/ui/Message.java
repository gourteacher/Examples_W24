package com.college.examples.ui;

public class Message {

    private String message;
    private boolean isSent;

    public Message(String message, boolean isSent) {
        this.message = message;
        this.isSent = isSent;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSent() {
        return isSent;
    }

    @Override
    public String toString() {
        return message;
    }
}
