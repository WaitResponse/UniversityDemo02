package com.gem.kfc.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.gem.kfc.dao.AddressDAO;
import com.gem.kfc.dao.base.AbstractParser;
import com.gem.kfc.dao.base.BaseDAO;
import com.gem.kfc.pojo.User;
import com.gem.kfc.pojo.UserAddress;

public class AddressDAOImpl extends BaseDAO<UserAddress> implements AddressDAO {
	private class AddressParser extends AbstractParser<UserAddress>{

		public Set<UserAddress> parserRS(ResultSet rs) {
				Set<UserAddress>addSet=new HashSet<UserAddress>();
				try {
					while(rs.next()){
						int id=rs.getInt(1);
						String uname=rs.getString(2);
						String address=rs.getString(3);
						String userTel=rs.getString(4);
						boolean defaultAddrFlag=rs.getBoolean(5);
						int uid=rs.getInt(6);
						User user=new User(uid);
						UserAddress userAddress=new UserAddress(id,address,uname,userTel,defaultAddrFlag,user);
						addSet.add(userAddress);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return addSet;
		}
				
	}
	AddressParser parser=new AddressParser();
	public Set<UserAddress>getAddress (int uid) {
		String sql="select *from t_address where userid=?";
		return super.executeQuery(parser, sql, uid);
	}

}
