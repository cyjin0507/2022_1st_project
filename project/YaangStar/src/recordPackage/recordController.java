package recordPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.JdbcUtil;
import dao.MemberDAO;

public class recordController {
	
	public int getLastIdxRecord() {
		int a = 0;

		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM (SELECT idx FROM recordTable ORDER BY idx DESC) WHERE ROWNUM=1");

			while (rs.next()) {
				a = rs.getInt("idx");
			}
			conn.close();
		} catch (Exception e) {
		}
		return a;
	}
	
	public int getLastUidx() {
		int a = 0;

		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT uidx FROM recordTable");

			while (rs.next()) {
				a = rs.getInt("uidx");
			}
			conn.close();
		} catch (Exception e) {
		}
		return a;
	}
	
	public int insertRecord(String idx, String uidx, String bidx) {
		int n = 0;
		
		// db 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into friendTable values(?, ?, ?)";

		conn = JdbcUtil.getConnection(); // JDBC 드라이버 메모리 로딩, DB연결
		MemberDAO dao = new MemberDAO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx); // idx +1
			pstmt.setString(2, uidx); // 
			pstmt.setString(3, bidx);// 내 아이디 세션

			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
		
	}
	
}
