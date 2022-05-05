package com.qa.ims.persistence.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.core.config.Order;

import com.qa.ims.persistence.domain.Item;

public class OrderDAO implements Dao<Order> {

	public OrderDAO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDAO(String orderName, String orderId) {
		// TODO Auto-generated constructor stub
	}

	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Order create(com.qa.ims.persistence.domain.Order created) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order update(com.qa.ims.persistence.domain.Order updated) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item modelFromResultSet1(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item read1(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create1(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update1(com.qa.ims.persistence.domain.Order updated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update1(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(OrderDAO orderDAO) {
		// TODO Auto-generated method stub
		
	}

	public Order create(OrderDAO orderDAO) {
		// TODO Auto-generated method stub
		return null;
	}

}
