package com.baicai.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baicai.mybatis.pojo.User;

public interface UserDaoForDynamicSql {
	//if
	public List<User> queryUserIf(String sex);
	public List<User> queryUserAnnoIf(@Param("sex") String sex);
	
	//choose、when、otherwise
	public List<User> queryUserChoose(@Param("sex") String sex, @Param("password") String password);
	
	//where
	public List<User> queryUserWhere(@Param("sex") String sex);
}
