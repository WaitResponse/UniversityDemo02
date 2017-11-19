package com.gem.java.fruit.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.gem.java.fruit.dao.CartItemDAO;
import com.gem.java.fruit.dao.base.BaseDAO;
import com.gem.java.fruit.pojo.CartItem;
import com.gem.java.fruit.pojo.Fruit;
import com.gem.java.fruit.pojo.User;

public class CartItemDAOImpl extends BaseDAO implements CartItemDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public Map<Integer, CartItem> getCartItemMap(int userId) {
		Map<Integer, CartItem> cartItemMap = new HashMap<Integer, CartItem>();
		conn=getConn();
		String sql="select t2.id,t2.buycount,t2.uid,t1.*from t_fruit t1 inner join t_cartitem t2 on t1.id=t2.fid where t2.uid=? ";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, userId);
			rs=psmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				int buyCount = rs.getInt(2);				
				int fid = rs.getInt(4);
				String name = rs.getString(5);
				int price = rs.getInt(6);
				Fruit fruit =new Fruit(fid,name,price);
				
				CartItem cartItem=new CartItem(id,fruit,buyCount,new User(userId));
				cartItemMap.put(fid,cartItem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
	
		return cartItemMap;
	}

	@Override
	public void addCartItem(CartItem cartitem) {	
		super.executeUpdate("insert into t_cartitem values(null,?,?,?)",cartitem.getCount(),cartitem.getUser().getId(),cartitem.getFruit().getId());	
	}

	@Override
	public void delCartItem(int cartItemId) {		
		super.executeUpdate("delete from t_cartitem where id=?", cartItemId);
	}

	
}
