package com.baicai.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baicai.mybatis.pojo.Order;

public class OrderDaoTest {
    
    private SqlSessionFactory sqlSessionFactory;
    private OrderDao orderDao;

    @Before
    public void setUp() throws Exception {
    	InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    
    //测试一级缓存
    @Test
    public void testCache1() {
    	SqlSession sqlSession = sqlSessionFactory.openSession();
        orderDao = sqlSession.getMapper(OrderDao.class);
        
    	System.out.println(this.orderDao.selectById(1L));
    	System.out.println("---------------------------");
    	//清除缓存方式1
    	//sqlSession.clearCache();
    	//清除缓存方式2
    	Order order = new Order();
    	order.setId(2);
    	order.setOrderNumber("20180606666");
    	this.orderDao.update(order);
    	System.out.println(this.orderDao.selectById(1L));
    	sqlSession.close();
    }
    
    //测试二级缓存
    @Test
    public void testCache2() {
    	SqlSession sqlSession1 = sqlSessionFactory.openSession();
        orderDao = sqlSession1.getMapper(OrderDao.class);
    	System.out.println(this.orderDao.selectById(1L));
    	sqlSession1.close();
    	
    	System.out.println("---------------------------");
    	
    	SqlSession sqlSession2 = sqlSessionFactory.openSession();
        orderDao = sqlSession2.getMapper(OrderDao.class);
        //清除缓存方式2
        Order order = new Order();
    	order.setId(2);
    	order.setOrderNumber("20180606666");
    	this.orderDao.update(order);
    	System.out.println(this.orderDao.selectById(1L));
    	sqlSession2.close();
    	
    	System.out.println("---------------------------");
    	
    	SqlSession sqlSession3 = sqlSessionFactory.openSession();
        orderDao = sqlSession3.getMapper(OrderDao.class);
    	System.out.println(this.orderDao.selectById(1L));
    	sqlSession1.close();
    }
}