package com.hc.utils;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class JdbcUtilsTest {

	@Test
	public void testGetConnection() {
		Connection conn = JdbcUtils.getConnection();
		assertTrue(conn != null);
		System.out.println(conn);
		JdbcUtils.close(conn, null);
	}

}
