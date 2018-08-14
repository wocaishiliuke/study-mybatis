package com.baicai.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.baicai.mybatis.pojo.Order;

public interface OrderDao {
	
	int update(Order order);
	
	//测试缓存
	Order selectById(@Param("id") Long id);
	
}
