package com.hc.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class JdbcUtils {
	private static final String URL;
	private static final String DRIVER;
	private static final String USERNAME;
	private static final String PASSWORD;

	static {
		Properties prop = null;
		try {
			prop = new Properties();
			prop.load(JdbcUtils.class.getResourceAsStream("jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		DRIVER = prop.getProperty("driver");
		// DRIVER = ResourceBundle.getBundle("jdbc").getString("driver");
		URL = prop.getProperty("url");
		USERNAME = prop.getProperty("username");
		PASSWORD = prop.getProperty("password");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
