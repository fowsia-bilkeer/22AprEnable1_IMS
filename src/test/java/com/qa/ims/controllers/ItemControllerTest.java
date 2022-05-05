package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemControllerTest {
	
	
	@Mock 
	private Utils utils;
	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController itemController;
	
	@Test	
	public void testCreate() {
		final String Item_name = "lollipop", Item_price = "1.80";
		final Item created = new Item(Item_name, Item_price);
		
		Mockito.when(utils.getString()).thenReturn(Item_name, Item_price);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, itemController.create());
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
@Test
public void testReadAll() {
	List<Item> items = new ArrayList<>();
	items.add(new Item(1L, "chewits", "1.80"));
	
	Mockito.when(dao.readAll()).thenReturn(items);
	
	assertEquals(items, itemController.readAll());
	
	Mockito.verify(dao, Mockito.times(1)).readAll();
}


@Test
public void testUpdate() {
	Item updated = new Item(1L, "double dips", "1.15");
	
	Mockito.when(this.utils.getLong()).thenReturn(1L);
	Mockito.when(this.utils.getString()).thenReturn(Item.getItemName(), Item.getItemPrice());
	Mockito.when(this.dao.update(updated)).thenReturn(updated);
	
	assertEquals(updated, this.itemController.update());
	
	Mockito.verify(this.utils, Mockito.times(1)).getLong();
	Mockito.verify(this.utils, Mockito.times(2)).getString();
	Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	
}

@Test

public void testDelete() {
	final long ID = 1L;
	
	Mockito.when(utils.getLong()).thenReturn(ID);
	Mockito.when(dao.delete(ID)).thenReturn(1);
	
	assertEquals(1L, this.itemController.delete());
	
	Mockito.verify(utils, Mockito.times(1)).getLong();
	Mockito.verify(dao, Mockito.times(1)).delete(ID);
	
}





public Utils getUtils() {
	return utils;
}

public void setUtils(Utils utils) {
	this.utils = utils;
}

public ItemDAO getDao() {
	return dao;
}

public void setDao(ItemDAO dao) {
	this.dao = dao;
}

public ItemController getController() {
	return itemController;
}

public void setController(ItemController controller) {
	this.itemController = controller;
}


}