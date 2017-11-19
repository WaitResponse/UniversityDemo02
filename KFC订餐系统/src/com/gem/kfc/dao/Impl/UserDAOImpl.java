package com.gem.kfc.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.gem.kfc.dao.UserDAO;
import com.gem.kfc.dao.base.BaseDAO;
import com.gem.kfc.dao.base.IParser;
import com.gem.kfc.pojo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
	public class UserParser implements IParser<User>{
		public Set<User> parserRS(ResultSet rs){
			Set<User>userSet=new HashSet<User>();
				try {
					while(rs.next()){
					int id=rs.getInt(1);
					String loginId = rs.getString(2);
					String pwd = rs.getString(3);
					String nickName = rs.getString(4);
					String realName = rs.getString(5);
					int balance = rs.getInt(6);
					
					User user=new User(id,loginId,pwd,nickName,realName,balance);
					userSet.add(user);
				} 
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return userSet;
			}
		public User loadRS(ResultSet rs) {
			try {
				if(rs.next()){
				int id=rs.getInt(1);
				String loginId = rs.getString(2);
				String pwd = rs.getString(3);
				String nickName = rs.getString(4);
				String realName = rs.getString(5);
				int balance = rs.getInt(6);
				return new User(id,loginId,pwd,nickName,realName,balance);
			} 
				
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		

		public Object parseComplexRS(ResultSet rs) {
			// TODO Auto-generated method stub
			return null;
		}
		
		}
		private UserParser parser=new UserParser();

	public User getUser(String loginId, String pwd) {
		String sql="select *from t_user where loginid=? and pwd=? ";
		//Set userSet= super.executeQuery(parser, sql, loginId,pwd);
		//return (userSet!=null&&userSet.size()>0)?(User)(userSet.toArray()[0]):null;
		//将userSet中的内容转换成一个对象数组，获取数组的第一个元素，并强转为User类型
		return super.loadRS(parser, sql, loginId,pwd);
	}

	public boolean addUser(User user) {
		String sql="insert into t_user value(null,?,?,?,?,?)";	
		return super.executeUpdate(sql, user.getLoginId(),user.getPwd(),user.getNickName(),user.getRealName(),user.getBalance());
	}

}
