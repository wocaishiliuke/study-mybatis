package com.baicai.mybatis.pojo.dto;

import com.baicai.mybatis.pojo.Order;
import com.baicai.mybatis.pojo.User;

public class OrderDTO2 extends Order {
	
	/** 用户信息 */
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OrderDTO2 [user=" + user + ", toString()=" + super.toString() + "]";
	}
    
}
