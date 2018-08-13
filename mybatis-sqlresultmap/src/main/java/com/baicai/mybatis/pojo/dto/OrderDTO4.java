package com.baicai.mybatis.pojo.dto;

import java.util.List;

import com.baicai.mybatis.pojo.Order;
import com.baicai.mybatis.pojo.User;

public class OrderDTO4 extends Order {
	
	/** 用户信息 */
	private User user;
	/** 订单详情 */
	private List<OrderDetailDTO> detailDTOList;
	
	public User getUser() {
		return user;
	}
	public List<OrderDetailDTO> getDetailDTOList() {
		return detailDTOList;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setDetailDTOList(List<OrderDetailDTO> detailDTOList) {
		this.detailDTOList = detailDTOList;
	}

	@Override
	public String toString() {
		return "OrderDTO4 [user=" + user + ", detailDTOList=" + detailDTOList + ", toString()=" + super.toString() + "]";
	}
	
}
