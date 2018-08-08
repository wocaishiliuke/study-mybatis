package com.baicai.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baicai.mybatis.pojo.User;

public interface UserDao {
	//根据id查询用户
	public User queryUserById(Long id);
	
	//新增用户
	public void insert(User user);
	
	//更新用户
	public void update(User user);
	
	//根据id删除用户
	public void deleteById(Long id);
	
	/** 测试#{}和${} */
	public User queryUserByUsername(@Param("username") String username);
	public List<User> queryUserLikeUsername(@Param("username") String username);
}
