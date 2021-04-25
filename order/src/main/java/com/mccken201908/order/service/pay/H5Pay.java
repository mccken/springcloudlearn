package com.mccken201908.order.service.pay;

import java.util.Map;

import org.springframework.stereotype.Service;


/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2021-03-07 21:22
 **/
@Service
public class H5Pay implements Pay{
	@Override
	public String tradeType() {
		return null;
	}

	@Override
	public void doPay(Map<String, String> packageParams) {
	}
}
