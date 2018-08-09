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
        List<User> list = this.userDao.queryUserIf("1");
        if(list != null && list.size() > 0) {
        	for(User user : list) { System.out.println(user); }
        }
    }
    
    @Test
    public void testQueryUserAnnoIf() {
    	List<User> list = this.userDao.queryUserAnnoIf("1");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
    public void testQueryUserChoose() {
    	List<User> list = this.userDao.queryUserChoose("1", "123456");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
    @Test
    public void testQueryUserWhere() {
    	List<User> list = this.userDao.queryUserWhere("1");
    	if(list != null && list.size() > 0) {
    		for(User user : list) { System.out.println(user); }
    	}
    }
    
  /*  @Test
	public void testInsert() {
		User user = new User();
		user.setAge(16);
		user.setBirthday(new Date());
		user.setName("白菜饼");
		user.setPassword("123456");
		user.setSex(2);
		user.setUsername("baicaibing");
		this.userDao.insert(user);
		System.out.println(user.getId());//测试主键回显
		//对于JDBC的transaction，没设置自动提交时，需手动提交事务，才会插入数据库
		//对于MANAGED的就没有设置自动提交事务的方法，而MySQL又默认自动提交，所以不需要手动提交
		this.sqlSession.commit();//这里的sqlSession要求是同一个会话
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(31L);
		user.setAge(16);
		user.setBirthday(new Date());
		user.setName("白菜饼0");
		user.setPassword("123456");
		user.setSex(2);
		user.setUsername("baicaibing");
		this.userDao.update(user);
		//对于JDBC的transaction，没设置自动提交时，需手动提交事务，才会插入数据库
		//对于MANAGED的就没有设置自动提交事务的方法，而MySQL又默认自动提交，所以不需要手动提交
		this.sqlSession.commit();//这里的sqlSession要求是同一个会话
	}*/
	
}