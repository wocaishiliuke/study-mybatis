package com.baicai.mybatis.dao;

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
}
