package userController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.JdbcUtil;
import dao.MemberDAO;

public class firendDAO {
	
	public boolean insertFollows(int userId1) {
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
			pstmt.setInt(1, 1); // idx +1 
			pstmt.setInt(2,userId1); //
			pstmt.setInt(3, 1);// 내 아이디 세션
			pstmt.setString(4, "false");
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
