package com.hanbit.web.global;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlTest {
	public static void main(String[] args) {
		Connection conn = null; // 지역변수 초기화
		Statement stmt = null;
		ResultSet rs = null; // deep copy (Interface)
		try {
			Class.forName(Constants.MYSQL_DRIVER);
			conn = DriverManager.getConnection(Constants.MYSQL_URL,Constants.ID,Constants.PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Test");
			String sample = "";
			while(rs.next())
			{
				sample = rs.getString("sample");
			}
			System.out.println("샘플 : " + sample);
		} catch (Exception e) {
			System.out.println("오라클 에러 발생");
			e.printStackTrace();
		}
	}
}
