package com.gem.kfc.dao;

import java.util.Set;

import com.gem.kfc.pojo.UserAddress;

public interface AddressDAO {
	public Set<UserAddress>getAddress(int uid);
}
