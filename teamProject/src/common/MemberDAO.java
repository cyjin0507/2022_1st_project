package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {

	public String myDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
		return sdf.format(new Date());
	}

	public int insertMember(int idx, String userId, String userPassword, String userName, String nickname, String major,
			String userType, String gender, String start_date, String reserved) {
		int n = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into userTable values(?,?,?,?,?,?,?,?,?,?)";

		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPassword);
			pstmt.setString(4, userName);
			pstmt.setString(5, nickname);
			pstmt.setString(6, major);
			pstmt.setString(7, userType);
			pstmt.setString(8, gender);
			pstmt.setString(9, start_date);
			pstmt.setString(10, reserved);
			pstmt.setString(11, reserved);
			
			System.out.println(start_date);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

}
