package com.example.user.users.consumers;

import org.springframework.kafka.annotation.KafkaListener;

public class PostRegistrationEmail {


    @KafkaListener(topics = "")
    public void sendEmailPostRegistration(String message){
        System.out.println(message);
    }

}
