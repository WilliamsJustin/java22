package day13src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JdbcTest {
	
	@Test
	public void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://192.168.179.128:3306/day13?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "peter", "peter");
		Statement stmt = conn.createStatement();
		String sql = "delete from user where id = 1";
		int ret = stmt.executeUpdate(sql);
		System.out.println(ret);
		stmt.close();
		conn.close();
	}

}
