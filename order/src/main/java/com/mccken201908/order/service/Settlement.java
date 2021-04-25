package com.mccken201908.order.service;

import java.math.BigDecimal;

/**
 * 结算接口
 */
public interface Settlement {
	
	// 客户类型
	String userType();
	
	// 所享折扣
	BigDecimal getPrice(BigDecimal bigDecimal);
}
