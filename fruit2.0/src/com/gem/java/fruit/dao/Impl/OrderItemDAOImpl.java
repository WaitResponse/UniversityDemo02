package com.gem.java.fruit.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gem.java.fruit.dao.OrderItemDAO;
import com.gem.java.fruit.dao.base.BaseDAO;
import com.gem.java.fruit.pojo.OrderItem;

public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	public void addOrderItem(OrderItem orderItem) {
		conn=getConn();
		String sql="insert into t_orderitem values(null,?,?,? )";
		 super.executeUpdate(sql, orderItem.getFruit().getId(),orderItem.getCount(),orderItem.getOrderBean().getId());
}
}
