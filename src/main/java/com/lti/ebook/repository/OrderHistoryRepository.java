package com.lti.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.ebook.model.OrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer>{

}
