package com.hc.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.hc.utils.JdbcUtils;

public class BigDataTest {
	@Test
	// 插入一幅图像进行 数据库
	// Blob: binary large object B L Ob
	public void testInsertBlob() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into testbig2 values (null, ?)";
			pstmt = conn.prepareStatement(sql);
			InputStream fis = new FileInputStream("D:\\teacher3\\javaweb\\02html\\练习图片\\girl3.jpg");
			// 1 代表第一个问号 ?
			pstmt.setBinaryStream(1, fis);

			int ret = pstmt.executeUpdate();
			if (ret > 0) {
				System.out.println("insert success !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
	}

	@Test
	public void testSelectBlob() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			String sql = "select * from testbig2 where id = 1";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			fos = new FileOutputStream("a.jpg");
			byte[] buff = new byte[10240];
			while (rs.next()) {
				InputStream in = rs.getBinaryStream("content");
				int len = -1;
				while ((len = in.read(buff)) != -1) {
					fos.write(buff, 0, len);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			JdbcUtils.close(conn, pstmt, rs);
		}
	}

}
