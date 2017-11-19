package com.gem.fruit.biz.Impl;

import java.util.List;

import com.gem.fruit.biz.FruitBiz;
import com.gem.fruit.dao.FruitDAO;
import com.gem.fruit.dao.Impl.FruitDAOImpl;
import com.gem.fruit.pojo.Fruit;
import com.gem.fruit.util.StringUtil;

public class FruitBizImpl implements FruitBiz {
	
	private FruitDAO fruitDAO=new FruitDAOImpl();
		
	public int getPageCount(String keyword, int pageSize) {
		int count=StringUtil.isEmpty(keyword)? fruitDAO.getFruitsCount():fruitDAO.getFruitsCount(keyword);
		return (count+pageSize-1)/pageSize;
	}//�жϲ�ѯ�ؼ����Ƿ�Ϊ�գ�����ǿյģ��ҳ����еļ�¼�����������ҳ��ض��ļ�¼����

	public List<Fruit> getFruitList(String keyword, int pageSize, int currPage) {
		
		return StringUtil.isEmpty(keyword) ? fruitDAO.getFruitList(pageSize, currPage) : fruitDAO.getFruitList(keyword, pageSize, currPage); 
	}

	public boolean addFruit(Fruit fruit) {
		if(!fruitDAO.isFruitNameExists(fruit.getFname())){//insert֮ǰҪ�ж�ˮ���Ƿ����
			return fruitDAO.addFruit(fruit);
		}
		return false;
	}

	public boolean updateFruit(Fruit fruit) {
		return fruitDAO.updateFruit(fruit);
	}

	public Fruit getFruit(int id) {
		return fruitDAO.getFruit(id);
	}

	public boolean delFruit(int id) {
		return fruitDAO.delFruit(id);
	}

}
