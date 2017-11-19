package com.gem.kfc.dao.Impl;

import com.gem.kfc.dao.OrderItemDAO;
import com.gem.kfc.dao.base.BaseDAO;
import com.gem.kfc.pojo.OrderItem;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements
		OrderItemDAO {

	public boolean addOrderItem(OrderItem orderItem) {
		String sql="insert into t_order_item values(null,?,?,?)";
		return super.executeUpdate(sql, orderItem.getGoods().getId(),
				orderItem.getCount(),orderItem.getOrder().getId());
	}

}
