package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;

public interface Dao<T> {

	List<T> readAll();
	
	T read(Long id);

	   default T create(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	T update(T t);

	int delete(long id);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;

	Item modelFromResultSet1(ResultSet resultSet) throws SQLException;

	Item read1(Long id);

	Item create1(Item t);

	Item update1(Item t);

	Item update1(Order updated);
}
