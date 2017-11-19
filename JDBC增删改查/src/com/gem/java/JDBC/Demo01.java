package com.gem.java.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Demo01 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("������������");
		String pname=input.next();
		System.out.print("���������䣺");
		int age=input.nextInt();
		System.out.print("������סַ��");
		String address=input.next();
		
		
	Connection conn=null;//�̺�һ��·
	PreparedStatement psmt=null;//׼����һ�����������������SQL
	    try {
	    	
	    	//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			//2.ͨ��������������ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb2?useUnicode=true&characterEncoding=UTF-8","root","root");
			//3.��дSQL���
			String sql="insert into t_person values(null,?,?,?)";
			//4.����Ԥ�������
			psmt=conn.prepareStatement(sql);
			//5.������
			psmt.setString(1,pname);
			psmt.setInt(2,age);
			psmt.setString(3,address);
			//6.ִ�и���(����ɾ���Ķ���֮Ϊ����)������Ӱ������
			int count=psmt.executeUpdate();
			System.out.println(count>0?"��ӳɹ���":"���ʧ�ܣ�");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}	    
	    catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			//7.�ͷ���Դ
				try {
				if(psmt!=null){					
				psmt.close();//���ճ���
				}
				if(conn!=null){			
					conn.close();//���յ�·
				}						
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			
		
		
		
		
	}
}
