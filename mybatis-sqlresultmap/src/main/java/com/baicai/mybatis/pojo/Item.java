package com.baicai.mybatis.pojo;

public class Item {
	
	private Integer id;
	
	private String itemName;
	
	private Float itemPrice;
	
	private String itemDetail;
	
	private Integer status;

	public Integer getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public Float getItemPrice() {
		return itemPrice;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDetail=" + itemDetail
				+ ", status=" + status + "]";
	}
	
}
