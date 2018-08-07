package com.baicai.mybatis.dao;

import java.util.List;

import com.baicai.mybatis.pojo.User;

//测试映射文件的Dao接口
public interface UserDao {
	//根据id查询用户
	public User queryUserById(Long id);
	
	//查询所有用户
	public List<User> queryAll();
	
	//新增用户
	public void insert(User user);
	
	//更新用户
	public void update(User user);
	 
	//根据id删除用户
	public void deleteById(Long id);
}
