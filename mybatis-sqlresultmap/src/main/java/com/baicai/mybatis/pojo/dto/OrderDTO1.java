package com.baicai.mybatis.pojo.dto;

import com.baicai.mybatis.pojo.Order;

public class OrderDTO1 extends Order {
	
	/** 用户信息 */
	private String username;
    private String password;
    private String name;
    
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "OrderDTO1 [username=" + username + ", password=" + password + ", name=" + name + ", toString()="
				+ super.toString() + "]";
	}
	
}
