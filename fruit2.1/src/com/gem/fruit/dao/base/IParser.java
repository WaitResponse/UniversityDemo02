package com.gem.fruit.dao.base;

import java.sql.ResultSet;
import java.util.List;

public interface IParser<T> {
	List<T>parserRS(ResultSet rs);
	T loadRS(ResultSet rs);
}
