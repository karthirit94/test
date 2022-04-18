package com.example.test.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "deal_product")
public class DealProduct {
	
	@Id
	@GeneratedValue
	private long id;
	private double dealPrice;
	private int quantity;
	private int customerBought = 0;
	@UpdateTimestamp
	private Timestamp time;
	private boolean dealPresent = true;
	public DealProduct(int id, double dealPrice, int quantity, Timestamp time) {
		super();
		this.id = id;
		this.dealPrice = dealPrice;
		this.quantity = quantity;
		this.time = time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public double getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}
	public int getCustomerBought() {
		return customerBought;
	}
	public void setCustomerBought(int customerBought) {
		this.customerBought = customerBought;
	}
	public boolean getIsDealPresent() {
		return dealPresent;
	}
	public void setDealPresent(boolean dealPresent) {
		this.dealPresent = dealPresent;
	}
	
}
