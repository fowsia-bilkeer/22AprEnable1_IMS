package com.qa.ims.persistence.domain;

import java.lang.annotation.Annotation;

public class Order implements org.apache.logging.log4j.core.config.Order {
	
	private Long id;
	private String orderName;
	private String orderPrice;
	
	public Order(String orderName, String orderPrice) {
		this.setOrderName(orderName);
		this.setOrderPrice(orderPrice);
	}
	public Order(Long id, String orderName, String orderPrice) {
		this.setId(id);
		this.setOrderName(orderName);
		this.setOrderPrice(orderPrice);
	
	
}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	
	public String toString() {
		return "id:" + id + "order name:" + orderName + "order price:" + orderPrice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderName == null) ? 0 : orderName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderPrice == null) ? 0 : orderPrice.hashCode());
		return result;
	}
	@Override
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getOrderName() == null) {
			if (other.getOrderName() != null)
				return false;
		} else if (!getOrderName().equals(other.getOrderName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderPrice == null) {
			if (other.orderPrice != null)
				return false;
		} else if (!orderPrice.equals(other.orderPrice))
			return false;
		return true;
	}
	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int value() {
		// TODO Auto-generated method stub
		return 0;
	}

}
