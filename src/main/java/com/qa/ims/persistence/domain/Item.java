package com.qa.ims.persistence.domain;

public class Item {
	
	
	private Long id;
	private Object itemName;
	private Object itemPrice;
	
	
	public Item(Long id, String item_name, String itemPrice2) {
		this.setId(id);
		this.setItemName(item_name);
		this.setItemPrice(itemPrice2);
	}

	public Item(String itemName, String item_price) {
		// TODO Auto-generated constructor stub
	}

	public Item(Long id2, String itemName2, float price) {
		// TODO Auto-generated constructor stub
	}

	public static  String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getItemPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public static long getItemId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
	}

	public void setItemPrice(String itemPrice2) {
	}
	
	@Override
	public String toString() {
		return "id:" + id + " item name:" + ItemName() + " item price:" + ItemPrice();

}
	
	
	private String ItemPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	private String ItemName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
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
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (Item.getItemName() != null)
				return false;
		} else if (!getItemName().equals(Item.getItemName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemPrice == null) {
			if (other.itemPrice != null)
				return false;
		} else if (!itemPrice.equals(other.itemPrice))
			return false;
		return true;
		
	}

	public Object create(Item created) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
	

