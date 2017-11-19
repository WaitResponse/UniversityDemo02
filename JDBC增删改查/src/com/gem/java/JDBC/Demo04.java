package com.gem.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Demo04 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb2?useUnicode=true&characterEncoding=UTF-8","root","root");		
		
			String sql="select*from t_person";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while(rs.next()){
				int id=rs.getInt(1);
				String pname =rs.getString(2);
				int age=rs.getInt(3);
				String address=rs.getString(4);
				
				System.out.println(id+"\t"+pname+"\t"+age+"\t"+address);
			}
		
		
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(rs!=null){
					rs.close();
					} 
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
