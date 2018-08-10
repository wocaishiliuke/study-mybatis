package com.baicai.mybatis.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baicai.mybatis.pojo.User;

public class UserDaoForTestParamTest {
	
	//sqlSession线程不安全
	private SqlSession sqlSession;
	private UserDaoForTestParam userDao;
	
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDaoForTestParam.class);
	}
	
	//1.单个非表字段参数,${}
	@Test
	public void testQueryAllByTableName() {
		List<User> list = this.userDao.queryAllByTableName("tb_user");
		//List<User> list = this.userDao.queryAllByTableNameWithAnno("tb_user");
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
	
	//2.单个表字段参数,#{}
	@Test
	public void testQueryUserById() {
		//System.out.println(this.userDao.queryUserById(1L));
		System.out.println(this.userDao.queryUserByIdWithAnno(1L));
	}
	
	//3.多个非表字段和表字段参数混合
	@Test
	public void testQueryAllByTableNamesAndIdName() {
		//List<User> list = this.userDao.queryAllByTableNamesAndIdName("tb_user", "tb_user", 1L, "张三");
		List<User> list = this.userDao.queryAllByTableNamesAndIdNameWithAnno("tb_user", "tb_user", 1L, "张三");
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
	
	//4.单个Map参数
	@Test
	public void testQueryAllByMap() {
		Map<String, Object> param = new HashMap<>(4);
		param.put("tableName", "tb_user");
		param.put("id", 1L);
		param.put("name", "张三");
		//List<User> list = this.userDao.queryAllByMap(param);
		List<User> list = this.userDao.queryAllByMapWithAnno(param);
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
	
	//5.单个POJO参数
	@Test
	public void testQueryAllByUser() {
		User paramUser = new User();
		paramUser.setId(1L);
		paramUser.setName("张三");
		//List<User> list = this.userDao.queryAllByUser(paramUser);
		List<User> list = this.userDao.queryAllByUserWithAnno(paramUser);
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
	
	//6.单个List参数
	@Test
	public void testQueryAllByIdList() {
		List<Long> ids = new ArrayList<>();
    	ids.add(1L);
    	ids.add(2L);
		//List<User> list = this.userDao.queryAllByIdList(ids);
		List<User> list = this.userDao.queryAllByIdListWithAnno(ids);
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
	
	//7.单个Set参数
	@Test
	public void testQueryAllByIdSet() {
		Set<Long> ids = new HashSet<>();
		ids.add(1L);
		ids.add(2L);
		List<User> list = this.userDao.queryAllByIdSet(ids);
		//List<User> list = this.userDao.queryAllByIdSetWithAnno(ids);
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
	
	//8.单个数组参数
	@Test
	public void testQueryAllByIdArray() {
		Long[] ids = new Long[] {1L, 2L};
		//List<User> list = this.userDao.queryAllByIdArray(ids);
		List<User> list = this.userDao.queryAllByIdArrayWithAnno(ids);
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
	
	//9.混合参数String、POJO、Map
	@Test
	public void testQueryAllByMixed() {
		String tableName = "tb_user";
		String userName = "baicai";
		User paramUser = new User();
		paramUser.setId(6L);
		Map<String, Object> param = new HashMap<>(4);
		param.put("name", "白菜饼0");
		//List<User> list = this.userDao.queryAllByMixed(tableName, userName, paramUser, param);
		//List<User> list = this.userDao.queryAllByMixedWithAnno(tableName, userName, paramUser, param);
		List<User> list = this.userDao.queryAllByMixedWithMixedAnno(tableName, userName, paramUser, param);
		if (null != list && list.size() > 0) {
			for (User user : list) { System.out.println(user); }
		}
	}
}