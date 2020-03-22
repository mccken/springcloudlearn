package com.mccken201908.member.controller;

import com.mccken201908.member.api.ProductApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class memberController {

	@Value("${server.port}")
	private String port;

	@Autowired
//	@SuppressWarnings("unchecked")
	private ProductApi productApi;

	@GetMapping("/hi")
	public String hiMember(String name) {

		String hiProduct = this.productApi.hiProduct(name);
//		String message = "member port: " + port + "and ";
		String message = "member port: " + port + "and " + hiProduct;
		return message;
	}

}
