package com.gem.java.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;



public abstract class BaseDAO {
	//获取连接对象
	protected Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb2?useUnicode=true&characterEncoding=UTF-8","root","root");
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	//释放资源
	protected void close(ResultSet rs,Statement psmt,Connection conn){	
			try {
				if(rs!=null){
				rs.close();
				} 
				if(psmt!=null){
					psmt.close();
				}
				if(conn!=null&&conn.isClosed()){
					conn.close();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

