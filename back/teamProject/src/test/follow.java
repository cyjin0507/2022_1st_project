package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.JdbcUtil;

public class follow {
	public int insertFollows(String userId1, String userId2) {
		int n = 0;
		
		// db 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into userid value(?, ?)";

		conn = JdbcUtil.getConnection(); // JDBC 드라이버 메모리 로딩, DB연결
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId1);
			pstmt.setString(1, userId2);
			n =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
		
	}
}
