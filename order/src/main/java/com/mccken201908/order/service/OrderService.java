package com.mccken201908.order.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.mccken201908.order.config.SpringUtil;
import com.mccken201908.order.dao.McckenOrderDAO;
import com.mccken201908.order.model.McckenOrder;
import com.mccken201908.order.model.McckenOrderExample;


//@SpringBootApplication
@Service
public class OrderService {

	@Autowired(required=false)
	private McckenOrderDAO mcckenOrderDAO;
	
	private List<Settlement> settlementList;
	
	public OrderService(List<Settlement> settlementList){
		this.settlementList = settlementList;
	}

	public List<McckenOrder> selectAllOrder() {
		McckenOrderExample example = new McckenOrderExample();
//		example.createCriteria().andUuidEqualTo("2");

		return this.mcckenOrderDAO.selectByExample(example);
	}
	
	public void getPrice(){

		Map<String, BigDecimal> bigDecimalMap = new HashMap<>();
		bigDecimalMap.put("vip", new BigDecimal(1));
		
		for (Settlement settlement : settlementList) {
			if (bigDecimalMap.containsKey(settlement.userType())) {
				System.out.println(settlement.getPrice(bigDecimalMap.get(settlement.userType())));
			}
		}
		System.out.println(1);
	}

	
	public static void main(String[] args) {

		
		ApplicationContext applicationContext = SpringUtil.getApplicationContext();
		
//		BuyThread buyThread = new BuyThread();
//		buyThread.start();

//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.yml");
		
//		OrderService bean1 = SpringUtil.getBean(OrderService.class);
//
//		OrderService bean = applicationContext.getBean(OrderService.class);
//
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(OrderService.class,args);
//		OrderService bean1 = applicationContext.getBean(OrderService.class);

//		bean1.getPrice();
//		System.out.println(1);
		
		
	}
}
