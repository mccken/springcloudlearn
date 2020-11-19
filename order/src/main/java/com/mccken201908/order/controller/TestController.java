package com.mccken201908.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2020-09-06 19:39
 **/

@RestController
//@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
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
