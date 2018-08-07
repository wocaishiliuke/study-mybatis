package com.baicai.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baicai.mybatis.pojo.User;

public interface UserMapper {
	
    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    public User selectOne(@Param("id") Long id);
    
}