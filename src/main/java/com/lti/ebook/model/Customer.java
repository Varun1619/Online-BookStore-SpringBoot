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
	@GenericGenerator(name="customer_seq",strategy="increment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_seq")
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
	@Column(name="email")
	private String email;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, String password, String shippingAddress, String billingAddress,
			long phoneNumber,String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.phoneNumber = phoneNumber;
		this.email=email;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", shippingAddress=" + shippingAddress + ", billingAddress=" + billingAddress + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
	
	
	
	
	

}
