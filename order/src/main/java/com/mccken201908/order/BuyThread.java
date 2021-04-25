package com.mccken201908.order;

//import com.huobi.client.req.trade.CreateOrderRequest;
//import com.huobi.entity.OrderEntity;
//import com.huobi.exchange.TradeService;
//import com.huobi.model.trade.Order;
//import com.huobi.webservice.RecorderService;
//import com.huobi.webutils.RecorderUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import com.mccken201908.order.service.OrderService;

@Component
public class BuyThread implements ApplicationListener<ApplicationStartedEvent> {

	@Autowired
	private OrderService orderService;

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		
		// 这里面去执行你需要执行的方法
		
		System.out.println("qqqqqqs");
		orderService.getPrice();
		System.out.println("ssss");
	}

}

