package com.lti.ebook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.ebook.model.ShoppingCart;
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	public abstract Optional<ShoppingCart> findByCustomer_customerIdAndBook_bookId(int customerId,int bookId);

}
