package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;


public class ItemDAO implements Dao<Item> {

public static final Logger LOGGER = LogManager.getLogger();
private Connection conn;
private Statement statement;

public ItemDAO() throws SQLException {
	this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "Fbilkeer");
	this.statement = conn.createStatement();		
}
public void createPerson(String itemName, double itemPrice) throws SQLException {
	String sql = String.format("CREATE TABLE item(`item_name`, `item_price`) VALUES ('%s', '%d');", itemName, itemPrice);
	statement.executeUpdate(sql);
}


public List<Item> readAll() {
	try (Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Items");) {
		List<Item> items = new ArrayList<>();
		while (resultSet.next()) {
			items.add(modelFromResultSet1(resultSet));
		}
		return items;
	} catch (SQLException e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return new ArrayList<>();
}
	@Override
	public Item modelFromResultSet1(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("item_id");
		String item_name = resultSet.getString("item name");
		String item_price = resultSet.getString("item_price");
		return new Item(id, item_name, item_price);
	}


		
	
	


	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}



@Override
public Item read(Long id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");) {
		statement.setLong(1, id);
		try (ResultSet resultSet = statement.executeQuery();) {
			resultSet.next();
			return modelFromResultSet1(resultSet);
		}
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;
				
		
	}

	




@Override
        public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO items(item_name, item_price) VALUES (?, ? )");) {
			statement.setString(1, Item.getItemName());
			statement.setString(2, Item.getItemPrice());
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	
}








@Override
public Item update(Item t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE items SET item_name = ?, item_price = ? WHERE item_id = ?");) {
			statement.setString(1, Item.getItemName());
			statement.setString(2, Item.getItemPrice());
			statement.setLong(3, Item.getItemId());
			statement.executeUpdate();
			return read(Item.getItemId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
}







@Override
public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}



@Override
public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
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
public Item update1(Item t) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Item update1(Order updated) {
	// TODO Auto-generated method stub
	return null;
}
}



