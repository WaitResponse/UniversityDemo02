package com.gem.fruit.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/fruit?useUnicode=true&characterEncoding=UTF-8","root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void close(ResultSet rs,PreparedStatement psmt,Connection conn){	
			try {
			if(rs!=null){
				rs.close();
			} 
			if(psmt!=null){
				psmt.close();
			}
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	protected boolean executeUpdate(String sql,Object...params){
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			setParams(psmt, params);
			return psmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return false;
	}
		
	protected void setParams(PreparedStatement psmt,Object...params) throws SQLException{
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
			psmt.setObject(i+1,params[i]);
			}
		}
	}	
	
	protected List<T> executeQuery(IParser<T>parser, String sql,Object...params){
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			setParams(psmt, params);
			rs=psmt.executeQuery();
			return parser.parserRS(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}
	
	protected T load(IParser<T> parser,String sql,int id){
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			setParams(psmt, id);
			rs=psmt.executeQuery();
			return parser.loadRS(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}
	
	
	
	
	
	}
	
	
	
	

