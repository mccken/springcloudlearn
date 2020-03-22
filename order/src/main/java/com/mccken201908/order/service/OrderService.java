package com.mccken201908.order.service;

import com.mccken201908.order.dao.McckenOrderDAO;
import com.mccken201908.order.model.McckenOrder;
import com.mccken201908.order.model.McckenOrderExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

	@Autowired
	private McckenOrderDAO mcckenOrderDAO;

	public List<McckenOrder> selectAllOrder() {
		McckenOrderExample example = new McckenOrderExample();
//		example.createCriteria().andUuidEqualTo("2");

		return this.mcckenOrderDAO.selectByExample(example);
	}
}
