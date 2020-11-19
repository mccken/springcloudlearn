package com.mccken201908.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2020-09-06 19:29
 **/
@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/get-demo")
	public String getDemo() throws Exception {
		
		if (true) {
			throw new Exception("500");
		}
		return "getDemo";
	}
}
