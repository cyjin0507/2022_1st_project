package userController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.JdbcUtil;
import dao.MemberDAO;

public class firendDAO {
	
	// friendTable에 다음 idx를 리턴하는 함수 (기본키에 대한 오류)
	public int getLastIdxFirend() {
		int a = 0;

		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM (SELECT idx FROM friendTable ORDER BY idx DESC) WHERE ROWNUM=1");

			while (rs.next()) {
				a = rs.getInt("idx");
			}
			conn.close();
		} catch (Exception e) {
		}
		return a;
	}
	
	
	// 팔로우 리스트에 담아주는 값을 담아주는 함수 
	public boolean insertFollows(String idx, int userId1, String myIdx) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into friendTable values(?, ?, ?, ?, sysdate)";

		conn = JdbcUtil.getConnection(); // JDBC 드라이버 메모리 로딩, DB연결
		MemberDAO dao = new MemberDAO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx); // idx +1 
			pstmt.setInt(2,userId1); // 친구의 idx값을 넣어준다
			pstmt.setString(3, myIdx);// 내 idx를 넣어준다
			pstmt.setString(4, "true"); // 기본값으로 true를 넣어준다
			n =pstmt.executeUpdate();
			
			return true; // 성공하면 true를 반환한다
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return false;  // 실패시 false를 반환한다.
		
	}

}
