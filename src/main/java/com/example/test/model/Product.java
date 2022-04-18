package com.example.test.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private double price;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deal_product_id")
	private DealProduct dealProduct;
	public Product(int id, String name, double price, DealProduct dealProduct) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dealProduct = dealProduct;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public DealProduct getDealProduct() {
		return dealProduct;
	}
	public void setDealProduct(DealProduct dealProduct) {
		this.dealProduct = dealProduct;
	}
	
}
