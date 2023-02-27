package com.lti.ebook.service;

import java.util.List;

import com.lti.ebook.model.OrderHistory;

public interface IOrderHistoryService {

	public abstract List<OrderHistory> getOrders(int userId);
}
