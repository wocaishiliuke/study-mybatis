package com.baicai.mybatis.pojo;

public class Order {
	
	private Integer id;
	
	private Long userId;
	
	private String orderNumber;

	public Integer getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderNumber=" + orderNumber + "]";
	}
	
}
