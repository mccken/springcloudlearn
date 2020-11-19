package com.mccken201908.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication1.class, args);
	}

}
