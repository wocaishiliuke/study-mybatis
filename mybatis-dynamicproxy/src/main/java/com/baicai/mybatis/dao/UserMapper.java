package com.baicai.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.baicai.mybatis.pojo.User;

//测试Java配置的Dao接口
public interface UserMapper {
	@Select("SELECT * FROM tb_user WHERE id = #{id}")
	public User queryUserById(Long id);
}
