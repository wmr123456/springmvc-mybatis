package com.wmr.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wmr.mybatis.entity.Order;
import com.wmr.mybatis.mapper.UserMaper;
import com.wmr.mybatis.service.OrderService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	OrderService orderService;
	@Autowired
	UserMaper userMaper;
	
	@RequestMapping("/order")
	public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
		List<Order> orderlist = userMaper.getUserOrders(1);
		ModelAndView mav = new ModelAndView("user_orders");
		mav.addObject("orders", orderlist);
		return mav;
	}
	
	@RequestMapping("insertOrder")
	public ModelAndView insertOrder() {
		ModelAndView mav = new ModelAndView("insert_order");
		userMaper.insertOrder(18, "13838381438", (float) 105.999, 1);
		return mav;
	}
	
	@RequestMapping("/deleteandinsert")
	public ModelAndView deleteAndInsert() {
		ModelAndView mav = new ModelAndView("delete_and_insert");
		try {
		orderService.deleteAndInsert(17, "13838381438", (float) 105.999, 1);
		}catch (Exception e) {
			System.out.println("¹þ¹þ¹þ¹þ»ò£¡");
		}
		return mav;
	}
}
