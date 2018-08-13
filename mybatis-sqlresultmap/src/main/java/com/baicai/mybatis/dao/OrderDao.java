package com.baicai.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baicai.mybatis.pojo.Order;
import com.baicai.mybatis.pojo.dto.OrderDTO1;
import com.baicai.mybatis.pojo.dto.OrderDTO2;
import com.baicai.mybatis.pojo.dto.OrderDTO3;
import com.baicai.mybatis.pojo.dto.OrderDTO4;

public interface OrderDao {
	
	//根据订单编号，查询订单及下单人信息
	OrderDTO1 selectOrderUserByOrderNum1(@Param("orderNumber") String orderNumber);
	OrderDTO2 selectOrderUserByOrderNum2(@Param("orderNumber") String orderNumber);
	
	//根据订单编号，查询订单及下单人信息，及订单详情
	OrderDTO3 selectOrderUserDetailByOrderNum(@Param("orderNumber") String orderNumber);
	
	//根据订单编号，查询订单及下单人信息，及订单详情，及商品信息
	List<OrderDTO4> selectOrderUserDetailItemList();
	
	//测试非嵌套的resultMap的自动映射
	Order selectOne(Long id);
	
	//测试FULL策略和autoMapping=true的差别
	OrderDTO2 selectOrderUser(@Param("orderNumber") String orderNumber);
}
