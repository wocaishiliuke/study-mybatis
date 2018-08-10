package com.baicai.mybatis.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baicai.mybatis.pojo.User;

public class UserDaoForDynamicSqlTest {
    
    //sqlSession线程不安全
    private SqlSession sqlSession;
    private UserDaoForDynamicSql userDao;

    @Before
    public void setUp() throws Exception {
    	InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        //动态代理方式
        userDao = sqlSession.getMapper(UserDaoForDynamicSql.class);
    }

    @Test
    public void testQueryUserIf() {
        List<User> list = this.userDao.queryUserIf("123456");
        if(list != null && list.size() > 0) {
        	for(User user : list) { System.out.println(user); }
        }
    }
    
    @Test
    public void testQueryUserAnnoIf() {
    	List<User> list = this.userDao.queryUserAnnoIf("123456");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
    public void testQueryUserChoose() {
    	List<User> list = this.userDao.queryUserChoose(1, "123456");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
    public void testQueryUserWhere() {
    	List<User> list = this.userDao.queryUserWhere("123456");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
	public void testUpdateUserSet() {
		User user = new User();
		user.setId(1L);
		user.setPassword("1111111");
		user.setSex(3);
		this.userDao.updateUserSet(user);
		this.sqlSession.commit();
	}
    
    @Test
    public void testQueryUserTrimWhere() {
    	List<User> list = this.userDao.queryUserTrimWhere("123456");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
  	public void testUpdateUserTrimSet() {
  		User user = new User();
  		user.setId(1L);
  		user.setPassword("888888");
  		user.setSex(3);
  		this.userDao.updateUserTrimSet(user);
  		this.sqlSession.commit();
  	}
    
    @Test
    public void testQueryUserForeachList() {
    	List<Long> ids = new ArrayList<>();
    	ids.add(1L);
    	ids.add(2L);
    	List<User> list = this.userDao.queryUserForeachList(ids);
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
    public void testQueryUserForeachSet() {
    	Set<Long> ids = new HashSet<>();
    	ids.add(1L);
    	ids.add(2L);
    	List<User> list = this.userDao.queryUserForeachSet(ids);
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
    public void testQueryUserForeachArray() {
    	List<User> list = this.userDao.queryUserForeachArray(new Long[] {1L,2L});
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
    public void testQueryUserBind() {
    	List<User> list = this.userDao.queryUserBind("123456");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
}