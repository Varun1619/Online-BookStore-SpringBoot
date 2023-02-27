package com.lti.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.ebook.model.OrderHistory;
import com.lti.ebook.model.ShoppingCart;
import com.lti.ebook.service.IShoppingCartService;

@RestController
public class CartController {
	
	@Autowired
	IShoppingCartService cartService;
	
	@RequestMapping(value="/add-to-cart",method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public ResponseEntity<ShoppingCart> addToCart(@RequestBody ShoppingCart cart)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","Added to cart successfully");
		ResponseEntity<ShoppingCart> response= new ResponseEntity<>(cartService.addToCart(cart),headers,HttpStatus.CREATED);
		return response;
	}
	@RequestMapping(value="/update-cart",method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public ResponseEntity<ShoppingCart> updateCart(@RequestBody ShoppingCart cart)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","Cart updated successfully");
		ResponseEntity<ShoppingCart> response= new ResponseEntity<>(cartService.updateCart(cart),headers,HttpStatus.CREATED);
		return response;
	}	
	
	@RequestMapping(value="/checkout",method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public ResponseEntity<OrderHistory> checkOut(@RequestBody List<ShoppingCart> carts)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","Order placed successfully");
		ResponseEntity<OrderHistory> response= new ResponseEntity<>(cartService.checkOut(carts),headers,HttpStatus.CREATED);
		return response;
	}

}
