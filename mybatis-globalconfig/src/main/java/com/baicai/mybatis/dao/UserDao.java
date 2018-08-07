package com.baicai.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.baicai.mybatis.pojo.User;

public interface UserDao {
	//根据id查询用户
	public User queryUserById(@Param("id") Long id);
	
}
