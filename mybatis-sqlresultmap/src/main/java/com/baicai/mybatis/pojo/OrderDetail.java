package com.baicai.mybatis.pojo;

public class OrderDetail {
	
	private Integer id;
	
	private Integer orderId;
	
	private Integer itemId;
	
	private Double totalPrice;
	
	private Integer status;

	public Integer getId() {
		return id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", totalPrice=" + totalPrice
				+ ", status=" + status + "]";
	}
	
}
