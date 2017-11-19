package com.gem.fruit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gem.fruit.dao.base.BaseDAO;
import com.gem.fruit.dao.base.IParser;
import com.gem.fruit.pojo.Fruit;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
	
	private class FruitParser implements IParser<Fruit>{

		public List<Fruit> parseRS(ResultSet rs) {
			List<Fruit> fruitList =new ArrayList<Fruit>();
			try {
				while(rs.next()){
					int id = rs.getInt(1);
					String fname = rs.getString(2);
					int price = rs.getInt(3);
					int count = rs.getInt(4);
					String remark = rs.getString(5);
					
					Fruit fruit = new Fruit(id, fname, price, count, remark);
					fruitList.add(fruit);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return fruitList;
		}

		public Fruit loadRS(ResultSet rs) {
			try {
				if(rs.next()){
					int id = rs.getInt(1);
					String fname = rs.getString(2);
					int price = rs.getInt(3);
					int count = rs.getInt(4);
					String remark = rs.getString(5);
					
					return new Fruit(id, fname, price, count, remark);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		public Object parseComplexRS(ResultSet rs) {
			try {
				if(rs.next()){
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	private FruitParser parser = new FruitParser();

	public List<Fruit> getFruitList() {
		String sql = "select * from t_fruit" ;
		return super.executeQuery(parser, sql);
	}

	public boolean addFruit(Fruit fruit) {
		return super.executeUpdate("insert into t_fruit values(null , ? , ? , ? , ? )" , fruit.getFname() , fruit.getPrice() , fruit.getCount() , fruit.getRemark() ) ;
	}

	public boolean updateFruit(Fruit fruit) {
		return super.executeUpdate("update t_fruit set fname = ? , price = ? , count = ? , remark = ? where id = ? " , fruit.getFname() , fruit.getPrice() , fruit.getCount() , fruit.getRemark() , fruit.getId()) ;
	}

	public boolean delFruit(int id) {
		return super.executeUpdate("delete from t_fruit where id = ? ", id);
	}

	public Fruit getFruit(int id) {
		String sql = "select * from t_fruit where id =? " ;
		return super.load(parser, sql, id);
	}

	public List<Fruit> getFruitList(int pageSize, int pageNum) {
		return getFruitList("", pageSize, pageNum);
	}

	public int getFruitsCount() {
		return getFruitsCount("");
	}

	public List<Fruit> getFruitList(String keyword, int pageSize, int pageNum) {
		String sql = "select * from t_fruit where fname like ? or remark like ? limit ? , ? " ;
		return super.executeQuery(parser, sql, "%"+keyword+"%","%"+keyword+"%", (pageSize * (pageNum-1)) , pageSize ) ;
	}

	public int getFruitsCount(String keyword) {
		String sql = "select count(*) from t_fruit where fname like ? or remark like ?";
		return (Integer) super.complexQuery(parser, sql, "%"+keyword+"%","%"+keyword+"%");
	}
}

/*
假设每页显示5条。当前需要显示第3页

5*2 , 5

*/

