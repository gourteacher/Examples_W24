package com.college.examples.ui;

public class Message {

    private String message;
    private String timeSent;
    public Message(String message, String timeSent) {
        this.message = message;
        this.timeSent = timeSent;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeSent() {
        return timeSent;
    }

    @Override
    public String toString() {
        return message;
    }
}
