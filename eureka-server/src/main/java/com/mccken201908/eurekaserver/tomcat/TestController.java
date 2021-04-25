package com.mccken201908.eurekaserver.tomcat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2021-01-08 18:53
 **/
@RestController
public class TestController {
	
	@GetMapping("test1")
	public void test1(){
		String name = Thread.currentThread().getName();
		System.out.println(name);
	}
}
