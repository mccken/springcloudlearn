package com.mccken201908.eurekaserver;

import java.util.Observable;
import java.util.Observer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
//		Observer
//		Observable
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	
	
}
