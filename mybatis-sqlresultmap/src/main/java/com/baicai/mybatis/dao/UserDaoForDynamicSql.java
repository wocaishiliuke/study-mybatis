package com.baicai.mybatis.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.baicai.mybatis.pojo.User;

public interface UserDaoForDynamicSql {
	//if
	public List<User> queryUserIf(String password);
	public List<User> queryUserAnnoIf(@Param("password") String password);
	
	//choose、when、otherwise
	public List<User> queryUserChoose(@Param("sex") Integer sex, @Param("password") String password);
	
	//where
	public List<User> queryUserWhere(@Param("password") String password);
	
	//set
	public int updateUserSet(User user);
	
	//trim-where
	public List<User> queryUserTrimWhere(@Param("password") String password);
	
	//trim-set
	public int updateUserTrimSet(User user);
	
	//foreach-List
	public List<User> queryUserForeachList(@Param("ids") List<Long> ids);
	
	//foreach-Set
	public List<User> queryUserForeachSet(@Param("ids") Set<Long> ids);
	
	//foreach-Array
	public List<User> queryUserForeachArray(@Param("ids") Long[] ids);
	
	//bind
	public List<User> queryUserBind(@Param("password") String password);
}
