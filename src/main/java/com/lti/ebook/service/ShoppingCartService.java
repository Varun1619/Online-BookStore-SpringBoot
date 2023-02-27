package com.lti.ebook.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.ebook.model.Book;
import com.lti.ebook.model.OrderHistory;
import com.lti.ebook.model.ShoppingCart;
import com.lti.ebook.repository.BookRepository;
import com.lti.ebook.repository.OrderHistoryRepository;
import com.lti.ebook.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService implements IShoppingCartService{

	private final Logger LOG= LoggerFactory.getLogger(this.getClass());
	@Autowired
	ShoppingCartRepository ShoppingCartRepo;
	
	@Autowired
	OrderHistoryRepository OrderHistoryRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Override
	public ShoppingCart addToCart(ShoppingCart cart) {
		// TODO Auto-generated method stub
		int total=cart.getQuantity()*cart.getBook().getPrice();
		cart.setTotalPrice(total);
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
		else if(cart.getQuantity()==0)
		{
			ShoppingCartRepo.delete(cart);
			String message="cart item deleted";
			LOG.warn(message);
			throw new RuntimeException(message);
		}
		else
		{
			Optional<ShoppingCart> bookInCart=ShoppingCartRepo.findByCustomer_customerIdAndBook_bookId(cart.getCustomer().getCustomerId(), cart.getBook().getBookId());
			if(bookInCart.isPresent())
			{
				cart.setCartId(bookInCart.get().getCartId());
				cart.setTotalPrice(cart.getQuantity()*cart.getBook().getPrice());
			}	
		     return ShoppingCartRepo.save(cart);
		}
	}


	@Override
	public OrderHistory checkOut(List<ShoppingCart> cart) {
		// TODO Auto-generated method stub
		int total=0;
		for(ShoppingCart item:cart)
		{
			total+=item.getTotalPrice();
			ShoppingCartRepo.delete(item);
			Book book=bookRepo.findById(item.getBook().getBookId()).get();
			if(item.getQuantity()<=book.getAvailability())
			book.setAvailability(book.getAvailability()-item.getQuantity());
			else
			{
			String message="Need exceeds availability";
			LOG.warn(message);
			throw new RuntimeException(message);
			}
				
		}
		
		OrderHistory order=new OrderHistory(cart,new Date(),total);
		OrderHistoryRepo.save(order);
		return null;
	}

}
