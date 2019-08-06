package com.mccken201908.member.api.impl;

import com.mccken201908.member.api.ProductApi;
import org.springframework.stereotype.Service;

@Service
public class ProductApiImpl implements ProductApi {
	@Override
	public String hiProduct(String productId) {
		return "sorry: " + productId;
	}
}
