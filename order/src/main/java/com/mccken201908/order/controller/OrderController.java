package com.mccken201908.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/show-order")
	public String showOrder(String orderId) {
		
		return "show port: " + port + ", orderId is: " + orderId;
	} 
}
