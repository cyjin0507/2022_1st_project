package userController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dao.JdbcUtil;
import dao.MemberDAO;

public class firendDAO {
	
	public boolean insertFollows(int userId1) {
		int n = 0;
		
		// db 연동
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into friendTable values(?, ?, ?, ?, ?)";

		conn = JdbcUtil.getConnection(); // JDBC 드라이버 메모리 로딩, DB연결
		MemberDAO dao = new MemberDAO();
		Date create_date;
		create_date = dao.myDate();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2,1);
			pstmt.setInt(3, userId1);
			pstmt.setString(4, "false");
			pstmt.setDate(5,(java.sql.Date) create_date);
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