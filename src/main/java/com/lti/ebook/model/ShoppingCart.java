package com.lti.ebook.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart{

	
	@Id
	@GenericGenerator(name="cart_seq",strategy="increment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cart_seq")
	@Column(name="cart_id")
	private int cartId;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name="total_price")
	private int totalPrice;

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Customer customer, Book book, int quantity) {
		super();
		this.customer = customer;
		this.book = book;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", customer=" + customer + ", book=" + book + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	

	

}