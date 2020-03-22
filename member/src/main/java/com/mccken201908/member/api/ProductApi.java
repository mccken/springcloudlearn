package com.mccken201908.member.api;

import com.mccken201908.member.api.impl.ProductApiImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product", fallback = ProductApiImpl.class)
public interface ProductApi {

	@GetMapping("/show-product")
	public String hiProduct(@RequestParam(value = "productId") String productId);
}
