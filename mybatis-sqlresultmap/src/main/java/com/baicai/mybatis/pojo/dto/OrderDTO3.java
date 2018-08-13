package com.baicai.mybatis.pojo.dto;

import java.util.List;

import com.baicai.mybatis.pojo.Order;
import com.baicai.mybatis.pojo.OrderDetail;
import com.baicai.mybatis.pojo.User;

public class OrderDTO3 extends Order {
	
	/** 用户信息 */
	private User user;
	/** 订单详情 */
	private List<OrderDetail> detailList;
	
	public User getUser() {
		return user;
	}
	public List<OrderDetail> getDetailList() {
		return detailList;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}
	
	@Override
	public String toString() {
		return "OrderDTO3 [user=" + user + ", detailList=" + detailList + ", toString()=" + super.toString() + "]";
	}
	
}
