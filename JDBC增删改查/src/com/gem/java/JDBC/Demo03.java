package com.gem.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Demo03 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement psmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb2?useUnicode=true&characterEncoding=UTF-8","root","root");

			String sql="update t_person set age=?,address=? where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,47);
			psmt.setString(2,"巨神峰");
			psmt.setInt(3,1);
			int count=psmt.executeUpdate();
			System.out.println(count>0?"修改成功！":"修改失败！");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			try {
				if(psmt!=null){
				psmt.close();
				}
				if(conn!=null){
					conn.close();
					}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}		
		}
	}
}
