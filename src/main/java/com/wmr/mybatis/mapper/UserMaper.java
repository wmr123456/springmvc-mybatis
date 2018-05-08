package com.wmr.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wmr.mybatis.entity.Order;
import com.wmr.mybatis.entity.User;

public interface UserMaper {
	@Select("SELECT * FROM user WHERE id=#{id}")
	public User getUserById(int userId);
	
	@Select("SELECT u.*,o.* FROM \"user\" u, \"order\" o WHERE u.id=o.user_id AND u.id=#{id}")
	public List<Order> getUserOrders(int userId);
	
	@Insert("INSERT INTO \"order\" 	VALUES (#{order_id}, #{user_id}, #{order_no}, #{money} )")
	public void insertOrder(@Param("order_id")int orderId, @Param("order_no")String orderNo, @Param("money")float money, @Param("user_id")int userId);
	
	@Delete("DELETE \"order\" WHERE order.order_id = ${order_id}")
	public void deleteOrder(@Param("user_id") int orderId);
	
}
