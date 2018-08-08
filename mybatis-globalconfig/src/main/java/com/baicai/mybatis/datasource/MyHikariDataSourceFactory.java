package com.baicai.mybatis.datasource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 自定义DataSourceFactory
 * @author yuzhou
 * @since 1.0.0
 */
public class MyHikariDataSourceFactory extends UnpooledDataSourceFactory {
	
	public MyHikariDataSourceFactory() {
		this.dataSource = new HikariDataSource();
	}
	
}
