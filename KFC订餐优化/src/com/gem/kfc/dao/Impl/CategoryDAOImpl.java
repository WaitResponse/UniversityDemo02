package com.gem.kfc.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.gem.kfc.dao.CategoryDAO;
import com.gem.kfc.dao.base.AbstractParser;
import com.gem.kfc.dao.base.BaseDAO;
import com.gem.kfc.pojo.Category;

public class CategoryDAOImpl extends BaseDAO<Category> implements CategoryDAO {
	
	public  class CategoryParser extends  AbstractParser<Category>{
		public Set parserRS(ResultSet rs) {
			Set<Category> categorySet =new HashSet<Category>();
			try {
				while(rs.next()){
					int id=rs.getInt(1);
					String cname = rs.getString(2);
					Category category = new Category(id , cname ) ;
					categorySet.add(category);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return categorySet;
		}
		
	}
	CategoryParser parser =new CategoryParser();
	public Set<Category> getCategories() {
		String sql="select *from t_category";
		return super.executeQuery(parser, sql);
	}

}
