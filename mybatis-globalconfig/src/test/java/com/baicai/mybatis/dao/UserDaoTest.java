package com.baicai.mybatis.dao;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baicai.mybatis.pojo.User;

public class UserDaoTest {
    
    //sqlSession线程不安全
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
    	InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        //动态代理方式
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void testQueryUserById() {
        System.out.println(this.userDao.queryUserById(1L));
    }

}