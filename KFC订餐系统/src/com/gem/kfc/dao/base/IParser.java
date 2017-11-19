package com.gem.kfc.dao.base;

import java.sql.ResultSet;
import java.util.Set;

public interface IParser<T> {
	Set<T>parserRS(ResultSet rs);
	T loadRS(ResultSet rs);
	Object parseComplexRS(ResultSet rs);
}
