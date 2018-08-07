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
    
    //sqlSession和userDao定义成成员变量，方便使用;sqlSession线程不安全，**开发不能定义成成员变量**
    private SqlSession sqlSession;
    private UserDao userDao;

    //实际setUp中代码应该在每个Test中重复书写的（避免线程安全问题），这里方便起见做了抽取
    @Before
    public void setUp() throws Exception {
    	InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //这里要用成员变量的sqlSession，不能用局部变量，因为在下面的@Test中要使用
        //SqlSession sqlSession = sqlSessionFactory.openSession();//不能用局部变量
        sqlSession = sqlSessionFactory.openSession();
        //实现类方式
        //userDao = new UserDaoImpl(sqlSession);
        //动态代理方式
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void testQueryUserById() {
        System.out.println(this.userDao.queryUserById(1L));
    }

    @Test
    public void testQueryAll() {
        List<User> list = this.userDao.queryAll();
        if (null != list && list.size() > 0) {
            for (User user : list) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(16);
        user.setBirthday(new Date());
        user.setName("白菜饼");
        user.setPassword("123456");
        user.setSex(2);
        user.setUsername("baicaibing");
        this.userDao.insert(user);
        //提交事务，才会插入数据库
        this.sqlSession.commit();//这里的sqlSession就是传入userDao构造的sqlSession，所以是同一个会话
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(7L);
        user.setAge(16);
        user.setBirthday(new Date());
        user.setName("白菜饼1");
        user.setPassword("123456");
        user.setSex(2);
        user.setUsername("baicaibing");
        this.userDao.update(user);
        //提交事务，才会更新数据库
        this.sqlSession.commit();//这里的sqlSession就是传入userDao构造的sqlSession，所以是同一个会话
    }

    @Test
    public void testDeleteById() {
        this.userDao.deleteById(7L);
        //提交事务，才会更新数据库
        this.sqlSession.commit();//这里的sqlSession就是传入userDao构造的sqlSession，所以是同一个会话
    }
}