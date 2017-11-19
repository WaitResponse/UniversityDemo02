package com.gem.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo02 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement psmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb2?useUnicode=true&characterEncoding=UTF-8","root","root");
			
			String sql="delete from t_person where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,6);
			int count =psmt.executeUpdate();
			System.out.println(count>0?"É¾³ý³É¹¦£¡":"É¾³ýÊ§°Ü£¡");
			
		} catch (ClassNotFoundException e) {

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
				}
					catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		
	}
}
