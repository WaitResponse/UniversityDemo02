package com.gem.java.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Demo01 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("请输入姓名：");
		String pname=input.next();
		System.out.print("请输入年龄：");
		int age=input.nextInt();
		System.out.print("请输入住址：");
		String address=input.next();
		
		
	Connection conn=null;//铺好一条路
	PreparedStatement psmt=null;//准备好一辆车，将数据运输给SQL
	    try {
	    	
	    	//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.通过驱动管理器获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb2?useUnicode=true&characterEncoding=UTF-8","root","root");
			//3.编写SQL语句
			String sql="insert into t_person values(null,?,?,?)";
			//4.创建预处理对象
			psmt=conn.prepareStatement(sql);
			//5.填充参数
			psmt.setString(1,pname);
			psmt.setInt(2,age);
			psmt.setString(3,address);
			//6.执行更新(增，删，改都称之为更新)，返回影响行数
			int count=psmt.executeUpdate();
			System.out.println(count>0?"添加成功！":"添加失败！");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}	    
	    catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			//7.释放资源
				try {
				if(psmt!=null){					
				psmt.close();//回收车子
				}
				if(conn!=null){			
					conn.close();//回收道路
				}						
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			
		
		
		
		
	}
}
