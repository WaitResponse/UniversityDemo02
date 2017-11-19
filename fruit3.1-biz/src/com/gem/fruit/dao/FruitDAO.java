package com.gem.fruit.dao;

import java.util.List;

import com.gem.fruit.pojo.Fruit;

public interface FruitDAO {
	List<Fruit> getFruitList();
	
	//每页显示pageSize条记录，当前显示第pageNum页
	List<Fruit> getFruitList(int pageSize , int pageNum);
	
	//获取总记录条数
	int getFruitsCount();
	
	//根据关键字查询, 每页显示pageSize条记录，当前显示第pageNum页
	List<Fruit> getFruitList(String keyword , int pageSize , int pageNum);
	//根据关键字查询, 获取总记录条数
	int getFruitsCount(String keyword);
	
	boolean addFruit(Fruit fruit);
	boolean updateFruit(Fruit fruit);
	boolean delFruit(int id);
	Fruit getFruit(int id);
	
	boolean isFruitNameExists(String name);
}
