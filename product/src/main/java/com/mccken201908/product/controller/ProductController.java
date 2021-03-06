package com.mccken201908.product.controller;

import java.util.ArrayList;
import java.util.List;

import com.mccken201908.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

	@Value("${server.port}")
	private String port;

	@Autowired
	private ProductService productService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/show-product")
	public String showProduct(String productId) {

		String hiOrder = this.productService.hiOrder(productId);

		String message = "111productId port is: " + port + ", order: " + hiOrder;
		System.out.println(message);
		return message;
	}

	@GetMapping("/test")
	public void toUserList() {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);

		list.stream().parallel().forEach(item -> {

			String s = restTemplate.getForObject("http://USER/user/get-demo", String.class);

			System.out.println(s);

		});
	}
}
