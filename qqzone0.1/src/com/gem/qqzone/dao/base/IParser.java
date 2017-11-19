package com.gem.qqzone.dao.base;

import java.sql.ResultSet;
import java.util.Set;

public interface IParser<T> {
	Set<T> parseRS(ResultSet rs);
	T loadRS(ResultSet rs);
	Object parseComplexRS(ResultSet rs);
}
