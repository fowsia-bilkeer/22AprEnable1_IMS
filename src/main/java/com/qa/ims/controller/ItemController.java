package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

//Takes in Item details for CRUD functionality


public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
			private ItemDAO itemDAO;
	        private Utils utils;
	        
	 public ItemController(ItemDAO itemDAO, Utils utils) {
		 super();
		 this.setItemDAO(itemDAO);
		 this.setUtils(utils);
	 }

	@Override
	public List<Item> readAll() {
			List<Item> items = itemDAO.readAll();
			for (Item item : items) {
				LOGGER.info(item.toString());
			}
			return items;

	}

	@Override
	public Item create() {
			LOGGER.info("Please enter a item name");
			String itemName = getInput();
			LOGGER.info("Please enter a item price");
			Float itemPrice = Float.valueOf(getInput());
		    Item item = itemDAO.create(new Item( itemName, itemPrice));
			LOGGER.info("Item created");
			return item;
		}

	

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the Id of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a item name");
		String itemName = getInput();
		LOGGER.info("Please enter a item price");
		Float itemPrice = Float.valueOf(getInput());
		Item item = itemDAO.update(new Item(id, itemName, itemPrice));
		LOGGER.info("Item Updated");
		return item;
		
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the Id of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		return itemDAO.delete(id);
		
		
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}
	 
	 
	        
	
	
	
	
	

}
