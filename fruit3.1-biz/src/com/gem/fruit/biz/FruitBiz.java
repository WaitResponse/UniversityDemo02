package com.gem.fruit.biz;

import java.util.List;

import com.gem.fruit.pojo.Fruit;

public interface FruitBiz {
	//通过查询关键字，一页显示的记录数，我告诉你符合条件的总页数
	int getPageCount(String keyword,int pageSize);
	
	//你告诉我查询关键字，告诉我显示第几页，一页显示多少条，我告诉你这个页的记录
	List<Fruit> getFruitList(String keyword,int pageSize,int currPage);
	
	//添加新水果
	boolean addFruit(Fruit fruit);
	
	//修改特定水果
	boolean updateFruit(Fruit fruit);
	//查询特定水果信息
	Fruit getFruit(int id);
	//删除水果
	boolean delFruit(int id);
}
