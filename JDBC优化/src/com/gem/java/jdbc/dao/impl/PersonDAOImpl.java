package com.gem.java.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gem.java.jdbc.base.BaseDAO;
import com.gem.java.jdbc.dao.PersonDAO;
import com.gem.java.jdbc.pojo.Person;

public class PersonDAOImpl extends BaseDAO implements PersonDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public boolean addPerson(Person person) {
		conn=getConn(); 
		String sql="insert into t_person values(null,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,person.getPname());
			psmt.setInt(2,person.getAge());
			psmt.setString(3,person.getAddress());
			
			return psmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return false;
	}

	@Override
	public boolean updatePerson(Person person) {
		conn=getConn();
		String sql="update t_person set pname=?,age=?,address=? where id=?";
		try {
			psmt=conn.prepareStatement(sql);
		
			psmt.setString(1,person.getPname());
			psmt.setInt(2,person.getAge());
			psmt.setString(3,person.getAddress());
			psmt.setInt(4, person.getId());
			
			return psmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		
		return false;
	}

	@Override
	public boolean delPerson(int id) {
		conn=getConn();
		String sql="delete from t_person where id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			
			return psmt.executeUpdate()>0;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		return false;
	}

	@Override
	public List<Person> getPersonList() {
		List<Person>personList=new ArrayList<Person>();
		conn=getConn();
		String sql="select *from t_person";
		
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String pname=rs.getString(2);
				int age=rs.getInt(3);
				String address=rs.getString(4);
				
				Person person=new Person(id,pname,age,address);
				personList.add(person);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		return personList;
	}

	@Override
	public Person getPerson(int id) {
		conn=getConn();
		String sql="select *from t_person where id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,id);
			
			rs=psmt.executeQuery();
			if(rs.next()){
				String pname =rs.getString(2);
				int age =rs.getInt(3);
				String address =rs.getString(4);
				return new Person(id,pname,age,address);
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
