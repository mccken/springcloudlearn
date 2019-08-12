package com.mccken201908.order.controller;

import com.mccken201908.order.model.McckenOrder;
import com.mccken201908.order.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	Logger log= LogManager.getLogger(OrderController.class);
	
	@GetMapping("/hi-order")
	public List<McckenOrder> selectAllOrder() {

		log.error("222222222222222222");
		return this.orderService.selectAllOrder();
	}
	
}
