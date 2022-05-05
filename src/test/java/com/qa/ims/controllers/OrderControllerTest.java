package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderControllerTest {
	@Mock
	private Utils utils;
	@Mock
	private OrderDAO dao;
	@Mock
	private OrderController controller;
	
	@Test
	
	public void testCreate() {
		final String order_name = "one", orderPrice = "1.80";
		final Order created = new Order(order_name, orderPrice);
		
		Mockito.when(utils.getString()).thenReturn(order_name, orderPrice);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	
	public void testReadAll() {
		List<Order> items = new ArrayList<>();
		items.addAll((Collection<? extends Order>) new Item(1L, "chewits", "1.80"));
		
		List<org.apache.logging.log4j.core.config.Order> orders = null;
		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(items, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	
	public void testUpdate() {
		Order updated = new Order(1L, "two", "1.50");
		
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		@SuppressWarnings("unused")
		OngoingStubbing<String> thenReturn = Mockito.when(this.utils.getString()).thenReturn(updated.getOrderName(), updated.getOrderPrice());
		
		
		assertEquals(updated, this.controller.update());
		
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
		
	}
	
	@Test
	
	public void testDelete() {
		final long ID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	
	
	

}
