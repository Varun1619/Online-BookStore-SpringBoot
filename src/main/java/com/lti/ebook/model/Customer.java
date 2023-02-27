package com.lti.ebook.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GenericGenerator(name="user_seq",strategy="increment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="customer_name")
	private String customerName;
	@Column(name="password")
	private String password;
	@Column(name="shipping_address")
	private String shippingAddress;
	@Column(name="billing_address")
	private String billingAddress;
	@Column(name="phone_number")
	private long phoneNumber;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, String password, String shippingAddress, String billingAddress,
			long phoneNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.phoneNumber = phoneNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUserName() {
		return customerName;
	}
	public void setUserName(String userName) {
		this.customerName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", shippingAddress="
				+ shippingAddress + ", billingAddress=" + billingAddress + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	

}
