package com.mccken201908.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccken201908.order.model.McckenOrder;
import com.mccken201908.order.service.OrderService;
//import javax.validation.constraints.NotNull;

@RestController
public class OrderController {

//	@NotNull
	private String port;

	@Autowired
	private OrderService orderService;

	@GetMapping("/show-order")
	public String showOrder(String orderId) {

		return "show port: " + port + ", orderId is: " + orderId;
	}
	
	Logger log = LogManager.getLogger(OrderController.class);

	@GetMapping("/hi-order")
	public List<McckenOrder> selectAllOrder(HttpServletRequest request, HttpServletResponse response) {
		log.error("222222222222222222");
		request.getSession().setAttribute("USER_SESSION", "mccken");
		return this.orderService.selectAllOrder();
	}
	
	


}
