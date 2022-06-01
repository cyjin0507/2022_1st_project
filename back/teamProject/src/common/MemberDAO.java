package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MemberDAO {

	public Date myDate() {
		
		Date date = new Date();
		long timeINMilliSeconds = date.getTime();
		
		java.sql.Date date1 = new java.sql.Date(timeINMilliSeconds);
		return date1;
		
	}

	public int getLastNumber() {
		int a = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM (SELECT idx FROM usertable ORDER BY idx DESC) WHERE ROWNUM=1");
			
			while (rs.next()) {
				System.out.println("가져오기 성공");
				System.out.println("idx 값 가져오기 성공");
				a = rs.getInt("idx");
				System.out.println(a);
				
			}
			conn.close();
		}catch(Exception e) {
			System.out.println("오류 발생");
			System.out.println("idx 값 가져오기 실패");
		}
		return a;
		
		
	}
	
	public int insertMember(int idx, String userId, String userPassword, String userName, String nickname, String major,
			String userType, String gender, Date start_date, String reserved1, String reserved2) {
		int n = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into userTable values(?,?,?,?,?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConnection();
	
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("idx : "+idx+"\t날짜 : " + start_date+"\tuserType : "+ userType+"\tgender : " + gender);
			pstmt.setInt(1, idx);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPassword);
			pstmt.setString(4, userName);
			pstmt.setString(5, nickname);
			pstmt.setString(6, major);
			pstmt.setString(7, userType);
			pstmt.setString(8, gender);
			pstmt.setDate(9, (java.sql.Date) start_date);
			pstmt.setString(10, reserved1);
			pstmt.setString(11, reserved2);

			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

}
