package com.baicai.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baicai.mybatis.dao.UserDao;
import com.baicai.mybatis.pojo.User;

//动态代理后可删除
public class UserDaoImpl implements UserDao {
    
    //sqlSession是线程不安全的，要在方法中获取，不能声明为成员变量(多线程共享);这里只是示意，方便测试，开发不能这么用
    private SqlSession sqlSession;
    
    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    @Override
    public User queryUserById(Long id) {
        return this.sqlSession.selectOne("UserMapper.selectOne", id);
    }

    @Override
    public List<User> queryAll() {
        return this.sqlSession.selectList("UserMapper.selectList");
    }

    @Override
    public void insert(User user) {
        this.sqlSession.insert("UserMapper.insert", user);
    }

    @Override
    public void update(User user) {
        this.sqlSession.update("UserMapper.update", user);
    }

    @Override
    public void deleteById(Long id) {
        this.sqlSession.delete("UserMapper.delete", id);
    }
}