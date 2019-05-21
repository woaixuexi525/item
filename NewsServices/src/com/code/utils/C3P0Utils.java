package com.code.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static ComboPooledDataSource dataSource;
	private static Connection connection ;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSouce() {
		return dataSource;
	}
	
	public static Connection getConn() {
		try {
			connection = dataSource.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
