package com.hc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.hc.utils.JdbcUtils;

public class CRUDTest {

	@Test
	// 查询，全表查询
	public void testQueryRows() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
	}
	
	@Test
	// 查询， 条件查询
	public void testQueryRow() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int i = 2;
		try {
			stmt = conn.createStatement();
			String sql = "select * from user where id = " + i;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
	}
	
	@Test
	// 增加一条记录 
	public void testAddRow() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		int i = 2;
		try {
			stmt = conn.createStatement();
			String sql = "insert into user(username, password, email) " + 
					"values ( '中国1' , '1238888', 'china@163.com')";
			System.out.println(sql);
			int ret = stmt.executeUpdate(sql);
			if (ret == 1) {
				System.out.println("添加用户成功 !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt);
		}
	}
	
	@Test
	// 修改一条记录 
	public void testUpdateRec() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		int i = 2;
		try {
			stmt = conn.createStatement();
			String sql = "update user set username= '未来' , password='abc' where id = 6";
			System.out.println(sql);
			int ret = stmt.executeUpdate(sql);
			if (ret == 1) {
				System.out.println("修改用户成功 !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt);
		}
	}
	
	@Test
	// 删除一条记录 
	public void testDeleteRec() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		int i = 2;
		try {
			stmt = conn.createStatement();
			String sql = " delete from user where id = 2";
			System.out.println(sql);
			int ret = stmt.executeUpdate(sql);
			if (ret == 1) {
				System.out.println("删除用户成功 !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt);
		}
	}

}
