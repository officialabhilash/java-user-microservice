package com.example.user.users.controllers;

import com.example.user.users.events.UserEventsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEvent {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Bean
    @Scope(scopeName = "prototype")
    public void sendMessage(UserEventsEnum event, String data) {
        kafkaTemplate.send(event.toString(), data);
        System.out.println("Sent: " + data + "\nOnTopic: " + event);
    }
}