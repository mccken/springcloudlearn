package com.mccken201908.order.controller;

import com.mccken201908.order.model.McckenOrder;
import com.mccken201908.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/show-order")
	public String showOrder(String orderId) {
		
		return "show port: " + port + ", orderId is: " + orderId;
	} 
	
	@GetMapping("/hi-order")
	public List<McckenOrder> selectAllOrder() {
		
		return this.orderService.selectAllOrder();
	}
}
