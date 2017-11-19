package com.gem.kfc.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.gem.kfc.dao.CartItemDAO;
import com.gem.kfc.dao.base.AbstractParser;
import com.gem.kfc.dao.base.BaseDAO;
import com.gem.kfc.pojo.CartItem;
import com.gem.kfc.pojo.Goods;
import com.gem.kfc.pojo.User;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
	public class CartItemParser extends AbstractParser<CartItem>{

		public Set<CartItem> parserRS(ResultSet rs) {
			Set<CartItem>cartItemSet=new HashSet<CartItem>();
			try {
				while(rs.next()){
					int id = rs.getInt(1);
					int gid = rs.getInt(2);
					String gname = rs.getString(3);
					int price = rs.getInt(4);
					int count = rs.getInt(5);
					int uid = rs.getInt(6); 
					
					User user = new User(uid) ;
					Goods goods = new Goods(gid , gname , price );
					
					CartItem cartItem=new CartItem(id,goods,count,user);
					cartItemSet.add(cartItem);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cartItemSet;
		}	
	}
	CartItemParser parser=new CartItemParser();
	public Set<CartItem> getCartItem(int uid) {
		StringBuilder str=new StringBuilder("select t2.id , t2.gid , t1.gname , t1.price , t2.count , t2.uid ")
					.append(" from t_goods t1 ")
					.append(" inner join t_cart_item t2 ")
					.append(" on t1.id = t2.gid ")
					.append("where uid = ? ");
		String sql=str.toString();
		return super.executeQuery(parser, sql, uid);
					
	}

	public CartItem addCartItem(CartItem cartItem) {
		String sql = "insert into t_cart_item values(null , ? , ? , ? , 0)" ;
		int id = super.executeUpdateReturnGeneratedKey(sql, cartItem.getGoods().getId() , cartItem.getCount() , cartItem.getUser().getId()) ;
		if(id!=0){
			cartItem.setId(id);
			return cartItem ;
		}
		return null;
	}

	public boolean updateCartItem(CartItem cartItem) {
	String sql="update t_cart_item set count=? where id=?";
	return super.executeUpdate(sql, cartItem.getCount(),cartItem.getId());
	}

	public boolean delCartItem(int gid) {
		String sql="delete from t_cart_item where gid=?";
		return super.executeUpdate(sql, gid);
	}
	public boolean delCartItemBycid(int cid){
		String sql="delete from t_cart_item where id=?";
		return super.executeUpdate(sql, cid);
	}
}
