package com.mccken201908.member.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("order")
public interface OrderApi {

	@GetMapping(value = "/show-order")
	public String helloOrder(String orderId);
}
