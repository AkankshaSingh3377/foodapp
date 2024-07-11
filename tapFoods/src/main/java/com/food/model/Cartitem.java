package com.food.model;

public class Cartitem {
	
	private int itemId;
	private int restaurantId;
	private String name;
	private int quantity;
	private double price;
	
	public Cartitem() {
		// TODO Auto-generated constructor stub
	}

	public Cartitem(int itemId, int restaurantId, String name, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void updateItem(int itemId2, int quantity2) {
		// TODO Auto-generated method stub
		
	}

	public void removeItem(int itemId2) {
		// TODO Auto-generated method stub
		
	}

	public void addItem(Cartitem item) {
		// TODO Auto-generated method stub
		
	}
}
