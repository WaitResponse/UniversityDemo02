package com.gem.java.fruit.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gem.java.fruit.dao.FruitDAO;
import com.gem.java.fruit.dao.base.BaseDAO;
import com.gem.java.fruit.pojo.Fruit;


public class FruitDAOImpl extends BaseDAO implements FruitDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public boolean addFruit(Fruit fruit) {
	String sql="insert into t_fruit values(null,?,?,?,?)";
	return super.executeUpdate(sql,fruit.getName(),fruit.getPrice(),fruit.getCount(),fruit.getRemark())>0;
	
	}

	@Override
	public boolean delFruit(int id) {
		String sql="delete from t_fruit where id=?";
		return super.executeUpdate("delete from t_fruit where id=?", id)>0;		
	}

	@Override
	public boolean updateFruit(Fruit fruit) {
		String sql="update t_fruit set name=?,price=?,count=?,remark=? where id=?";
		return super.executeUpdate(sql,fruit.getName(),fruit.getPrice(),fruit.getCount(),fruit.getRemark(),fruit.getId())>0;		
	}

	@Override
	public List<Fruit> getFruitList() {
		List<Fruit>fruitList=new ArrayList<Fruit>();
		conn=getConn();
		String sql="select *from t_fruit";
		
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				int count=rs.getInt(4);
				String remark=rs.getString(5);
				
				Fruit fruit=new Fruit(id,name,price,count,remark);
				fruitList.add(fruit);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		return fruitList;
	}

	@Override
	public Fruit getFruit(int id) {
		conn=getConn();
		String sql="select *from t_fruit where id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,id);
			
			rs=psmt.executeQuery();
			if(rs.next()){
				String name =rs.getString(2);
				double price =rs.getDouble(3);
				int count =rs.getInt(4);
				String remark=rs.getString(5);
				return new Fruit(id,name,price,count,remark);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		return null;
	}
	public Fruit getFruitByName(String name) {
		conn = getConn() ;
		String sql = "select * from t_fruit where name = ? " ;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt(1);
				int price = rs.getInt(3);
				int count = rs.getInt(4);
				String remark = rs.getString(5);
				
				return new Fruit(id, name, price, count, remark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, psmt, conn);
		}
		return null;
	}
	public List<Fruit> getFruitListAsc() {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		conn = getConn() ;
		String sql = "select * from t_fruit order by price asc " ;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int count = rs.getInt(4);
				String remark = rs.getString(5);
				
				Fruit fruit = new Fruit(id, name, price, count, remark);
				fruitList.add(fruit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, psmt, conn);
		}
		return fruitList;
	}
}
