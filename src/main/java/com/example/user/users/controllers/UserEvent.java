package com.example.user.users.controllers;

import com.example.user.users.events.UserEventsEnum;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Getter
public class UserEvent {

    private final UserEventsEnum event;

    public UserEvent(UserEventsEnum event) {
        this.event = event;
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String data) {
        kafkaTemplate.send(event.toString(), data);
        System.out.println("Sent: " + event);
    }
}