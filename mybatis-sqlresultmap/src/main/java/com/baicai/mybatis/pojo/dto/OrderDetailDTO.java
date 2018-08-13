package com.baicai.mybatis.pojo.dto;

import com.baicai.mybatis.pojo.Item;
import com.baicai.mybatis.pojo.OrderDetail;

public class OrderDetailDTO extends OrderDetail {
	
	/** 商品信息 */
	private Item item;

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [item=" + item + ", toString()=" + super.toString() + "]";
	}
	
}
