package com.hanbit.web.global;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseServiceImpl implements DatabaseService {
	private static final Logger logger = LoggerFactory.getLogger(DatabaseServiceImpl.class);
	private String driver, url, id, password;
	private Connection conn;

	public DatabaseServiceImpl(String driver, String url, String id, String password) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.password = password;
	}

	@Override
	public Connection getConnection() {
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.url, this.id, this.password);

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
		return conn;
	}

}
