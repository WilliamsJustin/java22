package day13src;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class PrepareTest {
	@Test
	public void testWriteBig() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://192.168.179.128:3306/day13?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "peter", "peter");
		String sql = "insert into test(aaa) values ( ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		File file = new File("d:/tmp/day04.jar");
		InputStream  fis = new FileInputStream(file);
		pstmt.setBinaryStream(1, fis, (int)file.length());
		int ret = pstmt.executeUpdate();
		System.out.println("ret is " + ret);
		fis.close();
		pstmt.close();
		conn.close();
	}
	
	@Test
	public void testReadBig() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://192.168.179.128:3306/day13?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "peter", "peter");
		String sql = "select * from test where id = 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			InputStream fis = rs.getBinaryStream("aaa");
			int ch = 0;
			while( (ch = fis.read()) != -1) {
				
			}
		}
		/*
		PreparedStatement pstmt = conn.prepareStatement(sql);
		File file = new File("d:/tmp/day04.jar");
		InputStream  fis = new FileInputStream(file);
		pstmt.setBinaryStream(1, fis, (int)file.length());
		int ret = pstmt.executeUpdate();
		System.out.println("ret is " + ret);
		*/
		conn.close();
	}

}
