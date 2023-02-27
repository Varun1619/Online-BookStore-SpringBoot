package com.lti.ebook.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.ebook.model.OrderHistory;
import com.lti.ebook.model.ShoppingCart;
import com.lti.ebook.repository.OrderHistoryRepository;
import com.lti.ebook.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService implements IShoppingCartService{

	private final Logger LOG= LoggerFactory.getLogger(this.getClass());
	@Autowired
	ShoppingCartRepository ShoppingCartRepo;
	
	@Autowired
	OrderHistoryRepository OrderHistoryRepo;
	
	@Override
	public ShoppingCart addToCart(ShoppingCart cart) {
		// TODO Auto-generated method stub
		return ShoppingCartRepo.save(cart);
	}

	@Override
	public ShoppingCart updateCart(ShoppingCart cart) {
		// TODO Auto-generated method stub
		if(ShoppingCartRepo.findById(cart.getCartId()).isEmpty())
		{
			String message="Cart object not found ";
		    LOG.warn(message);
		    throw new RuntimeException(message);
		}
		else
		{
			Optional<ShoppingCart> bookInCart=ShoppingCartRepo.findByCustomer_customerIdAndBook_bookId(cart.getCustomer().getCustomerId(), cart.getBook().getBookId());
			if(bookInCart.isPresent())
				cart.setCartId(bookInCart.get().getCartId());
		     return ShoppingCartRepo.save(cart);	
		}
	}

	@Override
	public ShoppingCart removeFromCart(int id) {
		// TODO Auto-generated method stub
		Optional<ShoppingCart> cart=ShoppingCartRepo.findById(id);
		if(cart.isEmpty())
		{
			String message="cart with "+id+" not found ";
			LOG.warn(message);
			throw new RuntimeException(message);
		}
		else
		{
			ShoppingCartRepo.deleteById(id);
		    return cart.get();
		}
	}

	@Override
	public OrderHistory checkOut(List<ShoppingCart> cart) {
		// TODO Auto-generated method stub
		int total=0;
		for(ShoppingCart item:cart)
		{
			total+=item.getTotalPrice();
		}
		OrderHistory order=new OrderHistory(cart,new Date(),total);
		OrderHistoryRepo.save(order);
		return null;
	}

}
