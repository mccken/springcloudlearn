package com.mccken201908.order.service.pay;

import java.util.Map;

public interface Pay {

	// 支付类型
	String tradeType();

	// 实际上去做支付的事情
	void doPay(Map<String, String> packageParams);
}
