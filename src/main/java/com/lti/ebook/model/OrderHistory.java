package com.lti.ebook.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrderHistory {
	
	@Id
	@GenericGenerator(name="order_seq",strategy="increment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="order_seq")
	@Column(name="order_id")
	private int orderId;
	
	@OneToMany
	@JoinColumn(name="cart_id")
	private List<ShoppingCart> shoppingCart;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="gross_total")
	private int gross_total;

	public OrderHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderHistory(List<ShoppingCart> shoppingCart, Date date, int gross_total) {
		super();
		this.shoppingCart = shoppingCart;
		this.date = date;
		this.gross_total = gross_total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<ShoppingCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<ShoppingCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public int getGross_total() {
		return gross_total;
	}

	public void setGross_total(int gross_total) {
		this.gross_total = gross_total;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "OrderHistory [orderId=" + orderId + ", shoppingCart=" + shoppingCart + ", gross_total=" + gross_total
				+ "]";
	}

}
