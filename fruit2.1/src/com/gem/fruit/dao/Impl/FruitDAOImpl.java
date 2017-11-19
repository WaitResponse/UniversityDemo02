package com.gem.fruit.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gem.fruit.dao.FruitDAO;
import com.gem.fruit.dao.base.BaseDAO;
import com.gem.fruit.dao.base.IParser;
import com.gem.fruit.pojo.Fruit;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
	private class FruitParser implements IParser<Fruit>{
	public List<Fruit> parserRS(ResultSet rs) {
		List<Fruit>fruitList=new ArrayList<Fruit>();
		try {
			while(rs.next()){
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				int price=rs.getInt(3);
				int count=rs.getInt(4);
				String remark=rs.getString(5);
				Fruit fruit=new Fruit(id,fname,price,count,remark);
				fruitList.add(fruit);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fruitList;
	}
	
	public Fruit loadRS(ResultSet rs) {		
		try {
			if(rs.next()){
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				int price=rs.getInt(3);
				int count=rs.getInt(4);
				String remark=rs.getString(5);
				return new Fruit(id,fname,price,count,remark);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	  }
}
	private FruitParser parser =new FruitParser();
	
	public List<Fruit>getFruitList(){
		String sql="select *from t_fruit";
		return super.executeQuery(parser, sql);		
	}
	
	public boolean addFruit(Fruit fruit) {
		String sql="insert into t_fruit values(null,?,?,?,?)";
		return super.executeUpdate(sql, fruit.getId(),fruit.getName(),fruit.getPrice(),fruit.getCount(),fruit.getRemark());
	}

	public boolean updateFruit(Fruit fruit) {
		String sql="update t_fruit set name=?,price=?,count=?,remark=? where id=?";
		return super.executeUpdate(sql,fruit.getName(),fruit.getPrice(),fruit.getCount(),fruit.getRemark(),fruit.getId());
	}

	public boolean delFruit(int id) {
		String sql="delete from t_fruit where id=?";
		return super.executeUpdate(sql,id);
	}
	public Fruit getFruit(int id) {
		String sql = "select * from t_fruit where id =? " ;
		return super.load(parser, sql, id);
	}

}
