package com.qa.ims.controller;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.utils.Utils;
public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.setOrderDAO(orderDAO);
		this.setUtils(utils);
	}
	
	
	@Override
	public List<Order> readAll() {
		List<Order> order = orderDAO.readAll();
		for(Order order1 : order) {
			LOGGER.info(order1.toString());
		}
		return order;
	}

	


	
	@Override
	public Order create() {
		LOGGER.info("Please enter the order name");
		String orderName = utils.getString();
		LOGGER.info("Please enter order id");
		String orderId = utils.getString();
		Order order = orderDAO.create(new OrderDAO(orderName, orderId));
		LOGGER.info("Order created");
		return order;
	}

	
	
	
	
	
	
	@Override
	public Order update() {
	LOGGER.info("Please enter the id of the order you would like to update");
	Long.valueOf(getInput());
	LOGGER.info("Please enter a order name");
	String orderName = utils.getString();
	LOGGER.info("Please enter order id");
	String orderId = utils.getString();
	orderDAO.update(new OrderDAO(orderName, orderId));
	
	
	return null;
	}
	
	
	

	private String getInput() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long.valueOf(getInput());
		LOGGER.info("Order deleted");
		return 0;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}
	

}
