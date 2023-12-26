package com.hc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JdbcHello {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1, 载入驱动
			Class.forName("com.mysql.jdbc.Driver");
			// DriverManager.registerDriver(new Driver());
			// 2， 创建  connect 对象
			String url = "jdbc:mysql://192.168.179.128:3306/day13?useSSL=false";
			conn = DriverManager.getConnection(url, "peter", "peter");
			// 3、  创建 statement 对象
			stmt = conn.createStatement();
			// 4、 执行 sql 语句， 返回 一个 ResultSet 对象
			String sql = "select * from user where id = 2";
			rs = stmt.executeQuery(sql);
			// 5、  遍历一下 ResultSet
			while(rs.next()) {
				// 1, id  2, username  3, password,  4. email

				// int id = rs.getInt(1);
				int id = rs.getInt("id");
				String strId = rs.getString("id");
				System.out.println(strId);
				String username = rs.getString("username");
				System.out.println(id + "-> " + username);
				System.out.println(rs.getObject("id") + "-> " + rs.getObject("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、 关闭 资源
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

}
