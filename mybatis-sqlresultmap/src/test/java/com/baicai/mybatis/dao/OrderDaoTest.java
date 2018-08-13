package com.baicai.mybatis.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baicai.mybatis.pojo.OrderDetail;
import com.baicai.mybatis.pojo.dto.OrderDTO2;

public class OrderDaoTest {
    
    //sqlSession线程不安全
    private SqlSession sqlSession;
    private OrderDao orderDao;

    @Before
    public void setUp() throws Exception {
    	InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        //动态代理方式
        orderDao = sqlSession.getMapper(OrderDao.class);
    }
    
    //测试resultMap
    @Test
    public void testResultMap() {
    	//OrderDTO1 orderUser = this.orderDao.selectOrderUserByOrderNum1("20180516001");
    	OrderDTO2 orderUser = this.orderDao.selectOrderUserByOrderNum2("20180516001");
    	//OrderDTO3 orderUser = this.orderDao.selectOrderUserDetailByOrderNum("20180516001");
    	//OrderDTO4 orderUser = this.orderDao.selectOrderUserDetailItemByOrderNum("20180516001");
    	//List<OrderDTO4> orders = this.orderDao.selectOrderUserDetailItemList();
        /*for(OrderDTO4 order : orders) {
        	System.out.println(order);
        	List<OrderDetailDTO> detailDTOList = order.getDetailDTOList();
        	for(OrderDetailDTO orderDetailDTO : detailDTOList) {
        		System.out.println(orderDetailDTO);
        	}
        }*/
    	System.out.println(orderUser);
        /*List<OrderDetail> detailList = orderUser.getDetailList();
        for(OrderDetail orderDetail : detailList) {
        	System.out.println(orderDetail);
        }*/
    }
    
    //测试非嵌套的resultMap的自动映射
    @Test
    public void testSelectOne() {
    	System.out.println(this.orderDao.selectOne(1L));
    }
    
  //测试FULL策略和autoMapping=true的差别
    @Test
    public void testSelectOrderUser() {
    	OrderDTO2 orderUser = this.orderDao.selectOrderUser("20180701086");
    	System.out.println(orderUser);
    }
}