package com.mccken201908.product.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "hiError")
	public String hiOrder(String orderId){

		String forEntity = this.restTemplate.getForObject("http://ORDER/show-order?orderId=" + orderId, String.class);
		System.out.println(forEntity);
		return forEntity;
	}
	
	public String hiError(String orderId) {
		
		return "hiError" + orderId; 
	}
}
