package com.baicai.mybatis.hello;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.baicai.mybatis.dao.UserMapper;
import com.baicai.mybatis.pojo.User;

public class MybatisTest {
	public static void main(String[] args) throws Exception {
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		//1.使用mybatis提供的工具类Resources，来加载配置文件
		/*String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//2.获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
		
		//3.获取（打开）连接
		//SqlSession sqlSession = sqlSessionFactory.openSession(true);//重载方法，增删改时不用手动提交this.sqlSession.commit(),自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.执行sql 【名称空间+statement的id】
		//User user = sqlSession.selectOne("suibian.selectOne", 3L);
		//使用Java配置时，configuration.addMapper相当于mapper标签的class属性，要满足3个条件
		User user = sqlSession.selectOne("com.baicai.mybatis.dao.UserMapper.selectOne", 3L);
		System.out.println(user);
		//5.关闭连接
		sqlSession.close();
	}
}
