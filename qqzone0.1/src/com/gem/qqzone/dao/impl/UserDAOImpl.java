package com.gem.qqzone.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.gem.qqzone.dao.UserDAO;
import com.gem.qqzone.dao.base.AbstractParser;
import com.gem.qqzone.dao.base.BaseDAO;
import com.gem.qqzone.pojo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
	
	private class UserParser extends AbstractParser<User>{
		@Override
		public Set<User> parseRS(ResultSet rs) {
			Set<User> users = new HashSet<User>();
			
			try {
				while(rs.next()){
					int id = rs.getInt(1);
					String loginId = rs.getString(2);
					String pwd = rs.getString(3);
					String nickName = rs.getString(4);
					String headImg = rs.getString(5);
					
					User user = new User(id, loginId, pwd, nickName, headImg);
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return users ;
		}

		@Override
		public User loadRS(ResultSet rs) {
			try {
				if(rs.next()){
					int id = rs.getInt(1);
					String loginId = rs.getString(2);
					String pwd = rs.getString(3);
					String nickName = rs.getString(4);
					String headImg = rs.getString(5);
					
					return new User(id, loginId, pwd, nickName, headImg);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null ;
		}
		
		
	}
	
	private UserParser parser = new UserParser();

	public User getUser(String loginId, String pwd) {
		String sql = "select * from t_user where loginId = ? and pwd = ? " ;
		Set<User> users = super.executeQuery(parser, sql, loginId , pwd );
		if(users!=null && users.size()>0){
			return (User) users.toArray()[0];
		}
		return null;
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(int id) {
		String sql = "select * from t_user where id = ? ";
		return super.load(parser, sql, id);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<User> getUsers(int id) {
		String sql = "select t1.* from t_user t1 inner join t_friend t2 on t1.id = t2.fid where t2.uid = ?" ;
		return super.executeQuery(parser, sql, id);
	}

}
