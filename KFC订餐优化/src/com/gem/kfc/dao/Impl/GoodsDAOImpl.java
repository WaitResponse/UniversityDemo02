package com.gem.kfc.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.gem.kfc.dao.GoodsDAO;
import com.gem.kfc.dao.base.AbstractParser;
import com.gem.kfc.dao.base.BaseDAO;
import com.gem.kfc.pojo.Category;
import com.gem.kfc.pojo.Goods;

public class GoodsDAOImpl extends BaseDAO<Goods> implements GoodsDAO {
	public class GoodsParser extends AbstractParser<Goods>{
		public Set parserRS(ResultSet rs) {
			Set<Goods>goodSet =new HashSet<Goods>();
				try {
					while(rs.next()){
						int id = rs.getInt(1);
						String gname = rs.getString(2);
						int price = rs.getInt(3);
						String img = rs.getString(4);
						int categoryId = rs.getInt(5);
						Goods goods = new Goods(id , gname , price , img , new Category(categoryId)) ;
						goodSet.add(goods);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return goodSet;
		}
		
	}
	private GoodsParser parser=new GoodsParser();

	public Set<Goods> getGoods() {
		String sql="select *from t_goods";
		return super.executeQuery(parser, sql );
	}

	public Set<Goods> getGoods(int categoryId) {
		String sql="select *from t_goods where categoryid=?";
		return super.executeQuery(parser, sql, categoryId);
	}

}
