package com.mccken201908.order.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mccken201908.order.OrderApplication;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes={OrderApplication.class})
public class OrderServiceTest extends TestCase {

	@Autowired
	OrderService orderService;
	
	@Test
	public void testGetPrice() {
		orderService.getPrice();
	}
}