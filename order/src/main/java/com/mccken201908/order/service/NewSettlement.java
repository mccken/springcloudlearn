package com.mccken201908.order.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2020-11-28 00:08
 **/
@Component
public class NewSettlement implements Settlement{
	@Override
	public String userType() {
		return "new";
	}

	@Override
	public BigDecimal getPrice(BigDecimal bigDecimal) {
		return bigDecimal.multiply(new BigDecimal(0.9));
	}
}
