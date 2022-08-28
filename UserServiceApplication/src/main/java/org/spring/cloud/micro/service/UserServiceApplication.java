package org.spring.cloud.micro.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {
	
	// https://www.youtube.com/watch?v=icTg6iTqpUk

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
