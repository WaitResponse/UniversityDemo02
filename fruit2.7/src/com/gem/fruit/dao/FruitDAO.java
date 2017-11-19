package com.gem.fruit.dao;

import java.util.List;

import com.gem.fruit.pojo.Fruit;

public interface FruitDAO {
	List<Fruit>getFruitList();//这个方法没有作用
	//每页显示pagesize条记录，当前显示的pageNum页
	List<Fruit>getFruitList(int pageSize,int pageNum);//这个方法也没用用
	//获取总记录条数，这个方法也没有用
	int getFruitsCount();
	//根据关键字查询，每页显示pageSize条记录，当前显示pageNum页
	List<Fruit>getFruitList(String keyword,int pageSize,int pageNum);
	//根据关键字查询，获取符合条件的记录条数
	int getFruitsCount(String keyword);
	boolean addFruit(Fruit fruit);
	boolean updateFruit(Fruit fruit);
	boolean delFruit(int id);
	Fruit getFruit(int id);
}
