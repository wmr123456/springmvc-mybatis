package com.wmr.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wmr.mybatis.mapper.UserMaper;

@Service
public class OrderService {
	@Autowired
	UserMaper userMaper;
	
	@Transactional
	public void deleteAndInsert(int orderId, String orderNo, float money, int userId) {
		userMaper.deleteOrder(orderId);
		userMaper.insertOrder(orderId, orderNo, money, userId);
		userMaper.insertOrder(orderId, orderNo, money, userId);
	}
}
