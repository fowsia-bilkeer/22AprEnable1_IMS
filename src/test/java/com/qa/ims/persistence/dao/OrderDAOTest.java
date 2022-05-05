package com.qa.ims.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	@Test
	public void testCreate() {
		final Order created = new Order(1L, "one", "1.80");
		Assert.assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, "two", "1.50"));
		Assert.assertEquals(expected, DAO.readAll());
	}
	
	
	@Test 
	public void testReadLatest() {
		assertEquals(new Order(1L, "one", "1.80"));
		
	}
	
		
	
	private void assertEquals(Order order) {
		
		
	}

	@Test
	
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, "one", "1.80"));
		
	}
	
	@Test
	
	public void testUpdate() {
		final Order updated = new Order(1L, "one", "1.80");
	}
	
	
	
	
	

}
