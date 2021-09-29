package com.example.Schedulers.domain;

public enum MessageStatus {
    MSG_SENT("message_sent"),
    MSG_RECEIVED("message_received"),
    MSG_FAILED("message_failed");

    private final String value;

    MessageStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
