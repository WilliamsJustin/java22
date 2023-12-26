package com.hc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import com.hc.utils.JdbcUtils;

public class BatchTest {
	@Test
	// statement 批处理
	public void testStatementBatch() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql1 = "update user set email = \"aaa@aaa.com\" where id = 9";
			String sql2 = "insert into user values(null, '11bbbbb" + new Random().nextInt(10000)
					+ "', 'cccc', 'fff@fff.com')";
			String sql3 = "delete from user where id=7";
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			int[] arr = stmt.executeBatch();
			System.out.println(Arrays.toString(arr));
			stmt.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt, null);
		}
	}

	@Test
	// preparedStatement 批处理
	public void testPreparedStatementBatch() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into user values (null, ?, ? , ?)";
			pstmt = conn.prepareStatement(sql);
			Random random = new Random();
			for (int j = 0; j < 5; j++) {
				for (int i = 0; i < 1000; i++) {
					pstmt.setString(1, "user" + (j+1)*10000 + i + 1);
					pstmt.setString(2, "p" + random.nextInt(10000));
					pstmt.setString(3, "e" + random.nextInt(10000) + "@aaa.com");
					pstmt.addBatch();
				}
				int[] arr = pstmt.executeBatch();
				System.out.println(Arrays.toString(arr));
				pstmt.clearBatch();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, null);
		}
	}

}
