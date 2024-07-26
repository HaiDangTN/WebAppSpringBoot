package com.website.tmdt.model;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Order_details {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int order_detail_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id",referencedColumnName = "order_id")
	private Orders order;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id",referencedColumnName = "order_id")
	private int product_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="unit_price")
	private BigDecimal unit_price;
	
	@Column(name="discount")
	private BigDecimal discount;
	
	@Column(name="total_price")
	private BigDecimal total_price;

	
	public Order_details() {}


	public int getOrder_detail_id() {
		return order_detail_id;
	}


	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}


	public Orders getOrder() {
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getUnit_price() {
		return unit_price;
	}


	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}


	public BigDecimal getDiscount() {
		return discount;
	}


	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}


	public BigDecimal getTotal_price() {
		return total_price;
	}


	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	
	
	
}
