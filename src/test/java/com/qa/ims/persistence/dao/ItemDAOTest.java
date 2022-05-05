package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.qa.ims.persistence.domain.Item;

public class ItemDAOTest {
	
	public ArrayList<Item> readAll1() throws SQLException{
		ArrayList<Item> items = new ArrayList<Item>();
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from items");) {
		while (resultSet.next()) {
			Long id = resultSet.getLong("id");
			String itemName = resultSet.getString("item_name");
			float price = resultSet.getFloat("price");
			Item item = new Item(id, itemName, price);
			items.add(item);
		    }
		return items;
		} 
	}

	
		@SuppressWarnings("static-access")
		public Item create(Item item) throws SQLException {
	try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/ims", "root", "root");
			Statement statement = connection.createStatement();) {			
		statement.executeUpdate("insert into items("
			+ "item_name, price)" + " values ('" + item.getItemName() + "'," + item.getItemPrice() +")");
	}
	return item;
}
		
		public Item update1(Item item) throws SQLException {
			try (Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ims", "root", "root");
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update items set item_name=" + Item.getItemName() + "', price=" + Item.getItemPrice() + " where id=" + item.getId());
			}
			return item;
		}
		
		public void delete(Long id) throws SQLException {
			try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ims", "root", "root");
				Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from order_items where item_id=" + id);
				statement.executeUpdate("delete from items where id=" + id);
							
			} 
			
		}
}
	
	
	
	
	
	

				
