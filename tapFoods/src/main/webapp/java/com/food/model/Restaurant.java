package com.food.model;

public class Restaurant {
	private String name;
	private String cusineType;
	private int deliveryTime;
	private String address;
	private int adminUserId;
	private double rating;
	private boolean isActive;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String name, String cusineType, int deliveryTime, String address, double rating, boolean isActive) 
	{
		super();
		this.name = name;
		this.cusineType = cusineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		//this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCusineType() {
		return cusineType;
	}

	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", cusineType=" + cusineType + ", deliveryTime=" + deliveryTime
				+ ", address=" + address + ", rating=" + rating + ", isActive=" + isActive + "]";
	}

	public void updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

}




