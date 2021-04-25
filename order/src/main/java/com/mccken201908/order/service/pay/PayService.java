package com.mccken201908.order.service.pay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2021-03-07 21:29
 **/
@SpringBootApplication
@Service
public class PayService {
	
	private List<Pay> payList;

	public PayService(List<Pay> payList) {
		this.payList = payList;
	}
	
	public void doPay() {
		Map<String, String> packageParams = new HashMap<>();
		packageParams.put("APP", "");

		for (Pay pay : payList) {
			if (packageParams.containsKey(pay.tradeType())) {
				// 实际执行
				pay.doPay(packageParams);
			}
		}
	}
	
}
