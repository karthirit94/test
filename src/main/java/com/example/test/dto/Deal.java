package com.example.test.dto;

import java.sql.Timestamp;

public class Deal {
	
	private long id;
	private double updatedPrice;
	private int updatedQuantity;
	private Timestamp updatedTime;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public double getUpdatedPrice() {
	return updatedPrice;
}
public void setUpdatedPrice(double updatedPrice) {
	this.updatedPrice = updatedPrice;
}
public int getUpdatedQuantity() {
	return updatedQuantity;
}
public void setUpdatedQuantity(int updatedQuantity) {
	this.updatedQuantity = updatedQuantity;
}
public Timestamp getUpdatedTime() {
	return updatedTime;
}
public void setUpdatedTime(Timestamp updatedTime) {
	this.updatedTime = updatedTime;
}

}