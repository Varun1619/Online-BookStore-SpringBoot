package com.lti.ebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.ebook.model.OrderHistory;
import com.lti.ebook.repository.OrderHistoryRepository;

@Service
public class OrderHistoryService implements IOrderHistoryService{

	@Autowired
	OrderHistoryRepository orderRepo;
	
	@Override
	public List<OrderHistory> getOrders(int userId) {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

}
