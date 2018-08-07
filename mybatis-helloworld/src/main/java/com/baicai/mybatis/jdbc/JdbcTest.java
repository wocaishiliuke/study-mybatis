package com.baicai.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
			//3.获取statement
			String sql = "select * from tb_user where id = ?";
			ps = conn.prepareStatement(sql);
			//4.设置参数
			ps.setLong(1, 3L);		//从1开始不是0
			//5.执行查询,获取结果集
			rs = ps.executeQuery();
			//6.处理结果集
			while (rs.next()) {
				System.out.println("id:" + rs.getLong(1));
				System.out.println("name:" + rs.getString("user_name"));
				System.out.println("password:" + rs.getString(3));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//7.关闭连接
			if (rs != null) { rs.close(); }
			if (ps != null) { ps.close(); }
			if (conn != null) { conn.close(); }
		}
	}
}
