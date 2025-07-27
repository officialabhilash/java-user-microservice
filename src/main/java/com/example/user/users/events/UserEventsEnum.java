package com.example.user.users.events;

public enum UserEventsEnum {
    REGISTERED("USER-REGISTERED"),
    VERIFICATION_SUCCESSFUL("USER-VERIFICATION-SUCCESSFUL"),
    ;

    private final String topic;

    UserEventsEnum(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString(){
        return topic;
    }
}
