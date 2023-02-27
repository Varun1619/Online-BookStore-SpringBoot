package com.lti.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.ebook.model.OrderHistory;
import com.lti.ebook.service.IOrderHistoryService;

@RestController
public class OrderHistoryController {
	
	@Autowired
	IOrderHistoryService orderService;
	
	
	@RequestMapping(value="/all-orders/{user-id}",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<OrderHistory>> allBooks(@PathVariable(name="user-id")int userId)
	{
		List<OrderHistory> orders = orderService.getOrders(userId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Orders of user "+userId+"successfully!");
		ResponseEntity<List<OrderHistory>> response = new ResponseEntity<>(orders, headers, status);
		return response;
	}

}
