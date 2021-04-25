package com.mccken201908.order.service;

import javax.xml.bind.SchemaOutputResolver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mccken201908.order.OrderApplication;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderApplication.class})
public class NewSettlementTest extends TestCase {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void testGetPrice() {
		orderService.getPrice();
		System.out.println("test");
	}
}