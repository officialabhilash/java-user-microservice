package com.example.user.users.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PostRegistrationEmail {


    @KafkaListener(id = "user-consumer-group", topics = "#{T(com.example.user.users.events.UserEventsEnum).REGISTERED.toString()}")
    public void sendEmailPostRegistration(String message){
        System.out.println("ATTENTION: PRINTING MESSAGE FROM KAFKA");
        System.out.println(message);
    }

}
