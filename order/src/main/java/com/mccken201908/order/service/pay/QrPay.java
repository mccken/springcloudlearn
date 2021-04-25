package com.mccken201908.order.service.pay;

import java.util.Map;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2021-03-07 21:23
 **/
public class QrPay implements Pay{
	@Override
	public String tradeType() {
		return "QR";
	}

	@Override
	public void doPay(Map<String, String> packageParams) {
//		packageParams.
	}
}
