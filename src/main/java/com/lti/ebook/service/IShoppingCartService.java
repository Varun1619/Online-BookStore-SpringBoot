package com.lti.ebook.service;

import java.util.List;

import com.lti.ebook.model.OrderHistory;
import com.lti.ebook.model.ShoppingCart;

public interface IShoppingCartService {
	
	public abstract ShoppingCart addToCart(ShoppingCart cart);
	public abstract ShoppingCart updateCart(ShoppingCart cart);
	public abstract OrderHistory checkOut(List<ShoppingCart> cart);
	

}
