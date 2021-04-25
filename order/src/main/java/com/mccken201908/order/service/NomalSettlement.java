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
public class NomalSettlement implements Settlement{
	@Override
	public String userType() {
		return "nomal";
	}

	@Override
	public BigDecimal getPrice(BigDecimal bigDecimal) {
		return bigDecimal;
	}
}
