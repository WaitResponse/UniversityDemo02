package com.gem.java.fruit.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.gem.java.fruit.dao.OrderDAO;
import com.gem.java.fruit.dao.base.BaseDAO;
import com.gem.java.fruit.pojo.OrderBean;

public class OrderDAOImpl extends BaseDAO implements OrderDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public int addOrderBean(OrderBean orderBean) {
		conn=getConn();
		String sql="insert into t_orderbean values(null,?,?,?)";
		return super.executeUpdateReturnGeneratedKey(sql, orderBean.getTotal(), 
				new Timestamp(orderBean.getOrderDate().getTime()), orderBean.getUser().getId());
		
}
}
