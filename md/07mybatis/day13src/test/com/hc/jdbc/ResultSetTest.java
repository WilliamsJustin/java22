package com.hc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.hc.utils.JdbcUtils;

public class ResultSetTest {
	@Test
	// 查询， 滚动结果集
	// 基本不会使用
	public void testQueryRows() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			
			rs.afterLast();
			if(rs.previous()) {
				System.out.println(rs.getInt("id") + "-->" + rs.getString("username"));
			}
			rs.previous();
			System.out.println(rs.getInt("id") + "-->" + rs.getString("username"));
			rs.updateString("password", "shit88888");
			rs.updateRow();
			// rs.deleteRow();
			// rs.updateRow();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
	}

}
