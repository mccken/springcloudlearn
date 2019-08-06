package com.mccken201908.product.controller;

import com.mccken201908.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/show-product")
	public String showProduct(String productId) {

		String hiOrder = this.productService.hiOrder(productId);

		String message = "productId port is: " + port +", order: " + hiOrder;
		System.out.println(message);
		return message;
	} 
}
