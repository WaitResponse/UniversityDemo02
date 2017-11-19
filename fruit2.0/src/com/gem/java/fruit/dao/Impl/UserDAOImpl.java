package com.gem.java.fruit.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.gem.java.fruit.dao.UserDAO;
import com.gem.java.fruit.dao.base.BaseDAO;
import com.gem.java.fruit.pojo.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public User login(String loginId,int pwd){
		conn=getConn();		
		String sql="select *from t_user where loginId=? and pwd=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,loginId);
			psmt.setInt(2,pwd);
			rs=psmt.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String nickName=rs.getString(4);
				String address=rs.getString(5);
				
				return new User(id,loginId,pwd,nickName,address);
			}					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
}
}
