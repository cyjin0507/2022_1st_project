package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	public static Connection getConnection() {
		Connection conn = null;

		try {// DB 연결 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe", "hr", "hr");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
/* pstmt or conn 열려 있으면 닫기 */
	public static void close(Connection conn, PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* rs 열려 있으면 닫기 */
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		close(conn, pstmt);
	}
}
