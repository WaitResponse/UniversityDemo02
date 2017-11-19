package com.gem.kfc.dao;

import com.gem.kfc.pojo.Order;

public interface OrderBeanDAO {
	//向数据库插入一条数据
	public Order addOrderBean(Order orderBean);
}
