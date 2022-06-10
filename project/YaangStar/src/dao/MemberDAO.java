package dao;

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

	public int getLastIdxUser() {
		int a = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM (SELECT idx FROM usertable ORDER BY idx DESC) WHERE ROWNUM=1");

			while (rs.next()) {
				System.out.println("idx (userTable)  값 가져오기 성공");
				a = rs.getInt("idx");
				System.out.println(a);

			}
			conn.close();
		} catch (Exception e) {
			System.out.println("idx (userTable) 값 가져오기 실패");
		}
		return a;

	}

	public int getLastIdxBoard() {
		int a = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM (SELECT idx FROM boardTable ORDER BY idx DESC) WHERE ROWNUM=1");

			while (rs.next()) {
				System.out.println("\nidx (boardTable) 값 가져오기 성공");
				a = rs.getInt("idx");
				System.out.println("getLastIdxBoard_idx : " + a);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("idx (boardTable) 값 가져오기 실패");
		}
		return a;

	}

	public int getLastIdxComment() {
		int a = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM (SELECT idx FROM commentTable ORDER BY idx DESC) WHERE ROWNUM=1");

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

	public int insertUser(int idx, String userId, String userPassword, String userName, String nickname, String major,
			String gender, Date start_date, String reserved1, String reserved2, String userProfile, String introduce,
			String phoneNumber, String mail) {
		int c = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into userTable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idx);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPassword);
			pstmt.setString(4, userName);
			pstmt.setString(5, nickname);
			pstmt.setString(6, introduce);
			pstmt.setString(7, phoneNumber);
			pstmt.setString(8, mail);
			pstmt.setString(9, major);
			pstmt.setString(10, gender);
			pstmt.setDate(11, (java.sql.Date) start_date);
			pstmt.setString(12, userProfile);
			pstmt.setString(13, reserved1);
			pstmt.setString(14, reserved2);

			c = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return c;
	}

	public int insertBoard(int idx, int uidx, String tage, String userContent, String image, Date create_date,
			String reserved1, String reserved2) {
		int c = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into boardTable values(?,?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("test_insertBoard");

			pstmt.setInt(1, idx);
			pstmt.setInt(2, uidx);
			pstmt.setString(3, tage);
			pstmt.setString(4, userContent);
			pstmt.setString(5, image);
			pstmt.setDate(6, (java.sql.Date) create_date);
			pstmt.setString(7, reserved1);
			pstmt.setString(8, reserved2);

			c = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return c;
	}

	public int insertComment(int idx, int uidx, int bidx, String commentContent, Date create_date, String reserved1,
			String reserved2) {
		int c = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into commentTable values(?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("test_insertComment");

			pstmt.setInt(1, idx);
			pstmt.setInt(2, uidx);
			pstmt.setInt(3, bidx);
			pstmt.setString(4, commentContent);
			pstmt.setDate(5, (java.sql.Date) create_date);
			pstmt.setString(6, reserved1);
			pstmt.setString(7, reserved2);

			c = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return c;
	}

	public int updateUser(int idx, String proFile, String name, String userNickname, String userIntroduce,
			String userMail, String userPhoneNumber, String userGender, String userMajor) {
		int d = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE userTable SET UPDATE usertable SET userProfile=?, userName = ?, nickname =?, introduce = ?, mail = ?, phoneNumber = ?, gender = ?, major = ? WHERE idx = ?";

		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, proFile);
			pstmt.setString(2, name);
			pstmt.setString(3, userNickname);
			pstmt.setString(4, userIntroduce);
			pstmt.setString(5, userMail);
			pstmt.setString(6, userPhoneNumber);
			pstmt.setString(7, userGender);
			pstmt.setString(8, userMajor);
			pstmt.setInt(9, idx);

			d = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
			d = 1;
		}

		return d;
	}

	public int updateContent(String userContent, String tage, int idx) {
		int d = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE boardTable SET tage = ?, userContent = ? where idx=?";
		System.out.println("test_updateContent");

		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tage);
			pstmt.setString(2, userContent);
			pstmt.setInt(3, idx);

			d = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
			d = 1;
		}

		return d;
	}

	public String getMyData(int idx, String keyword) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM userTable WHERE idx=" + idx);
			String returnData = null;
			while (rs.next()) {
				returnData = rs.getString(keyword);
			}
			conn.close();
			return returnData;
		} catch (Exception e) {
			System.out.println("idx (commentTable) 값 가져오기 실패");
		}

		return "test";
	}

}
