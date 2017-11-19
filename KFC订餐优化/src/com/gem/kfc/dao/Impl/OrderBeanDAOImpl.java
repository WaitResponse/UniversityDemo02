package com.gem.kfc.dao.Impl;

import java.util.Date;

import com.gem.kfc.dao.OrderBeanDAO;
import com.gem.kfc.dao.base.BaseDAO;
import com.gem.kfc.pojo.Order;

public class OrderBeanDAOImpl extends BaseDAO<Order> implements OrderBeanDAO {

	public Order addOrderBean(Order orderBean) {
		String sql="insert into t_order values(null,?,?,?,?,?)";
		int id=super.executeUpdateReturnGeneratedKey(sql,orderBean.getUser().getId(),
				orderBean.getOrderDate(),orderBean.getMoney(),
				orderBean.getOrderStatus(),orderBean.getAddress().getId());
		orderBean.setId(id);
		return orderBean;
	}

}
