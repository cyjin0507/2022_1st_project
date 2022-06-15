package userController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.JdbcUtil;
import dao.MemberDAO;

public class firendDAO {
	
	public int getLastIdxFirend() {
		int a = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM (SELECT idx FROM friendTable ORDER BY idx DESC) WHERE ROWNUM=1");

			while (rs.next()) {
				System.out.println("idx (commentTable)  값 가져오기 성공");
				a = rs.getInt("idx");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("idx (commentTable) 값 가져오기 실패");
		}
		return a;
	}
	
	public boolean insertFollows(String idx, int userId1, String myIdx) {
		int n = 0;
		
		// db 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into friendTable values(?, ?, ?, ?, sysdate)";

		conn = JdbcUtil.getConnection(); // JDBC 드라이버 메모리 로딩, DB연결
		MemberDAO dao = new MemberDAO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx); // idx +1 
			pstmt.setInt(2,userId1); //
			pstmt.setString(3, myIdx);// 내 아이디 세션
			pstmt.setString(4, "true");
			n =pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return false;
		
	}

}
