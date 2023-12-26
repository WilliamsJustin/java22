package com.hc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.hc.utils.JdbcUtils;

public class PreparedTest {
	
	@Test
	// 查询，全表查询
	// prepareStatement;
	public void testQueryRow() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where username = ? and id = ?";
			pstmt = conn.prepareStatement(sql);
			// 1 代表第一个问号 ?
			pstmt.setString(1, "tiger");
			pstmt.setInt(2, 5);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
	}

}
