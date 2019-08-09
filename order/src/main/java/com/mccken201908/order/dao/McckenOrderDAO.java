package com.mccken201908.order.dao;

import com.mccken201908.order.model.McckenOrder;
import com.mccken201908.order.model.McckenOrderExample;
import org.springframework.stereotype.Repository;

/**
 * McckenOrderDAO继承基类
 */
@Repository
public interface McckenOrderDAO extends MyBatisBaseDao<McckenOrder, Integer, McckenOrderExample> {
}