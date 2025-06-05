package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(
		exclude = {
				net.devh.boot.grpc.server.autoconfigure.GrpcServerSecurityAutoConfiguration.class
		}
)
//@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(UserApplication.class);

		// Hardcode the external config location
		Map<String, Object> defaultProps = new HashMap<>();
		defaultProps.put("spring.config.location", "file:/home/abhilash/Desktop/learning/learn-java/microservices/user-microservice/src/main/resources/application.properties");
		app.setDefaultProperties(defaultProps);
		app.run(args);
	}
}
