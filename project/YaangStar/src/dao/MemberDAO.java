package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {

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
				a = rs.getInt("idx");

			}
			conn.close();
		} catch (Exception e) {
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
				a = rs.getInt("idx");
			}
			conn.close();
		} catch (Exception e) {
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
				a = rs.getInt("idx");
			}
			conn.close();
		} catch (Exception e) {
		}
		return a;
	}

	public int insertUser(int idx, String userId, String userPassword, String userName, String nickname, String major,
			String gender, String reserved1, String reserved2, String userProfile, String introduce, String phoneNumber,
			String mail) {
		int c = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into userTable values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?)";
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
			pstmt.setString(11, userProfile);
			pstmt.setString(12, reserved1);
			pstmt.setString(13, reserved2);

			c = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return c;
	}

	public int insertBoard(int idx, String uidx, String tage, String userContent, String image, String reserved1,
			String reserved2) {
		int c = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into boardTable values(?,?,?,?,?, sysdate,?,?)";
		conn = JdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idx);
			pstmt.setString(2, uidx);
			pstmt.setString(3, tage);
			pstmt.setString(4, userContent);
			pstmt.setString(5, image);
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

	public int insertComment(String idx, String uidx, String bidx, String commentContent, String reserved1,
			String reserved2) {
		int c = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into commentTable values(?,?,?,?,sysdate,?,?)";
		conn = JdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, idx);
			pstmt.setString(2, uidx);
			pstmt.setString(3, bidx);
			pstmt.setString(4, commentContent);
			pstmt.setString(5, reserved1);
			pstmt.setString(6, reserved2);

			c = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return c;
	}

	public int updateUser(String proFile, String name, String userNickname, String userIntroduce, String userMail,
			String userPhoneNumber, String userGender, String userMajor, String idx) {

		int d = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE usertable SET userProfile=?, userName = ?, nickname =?, introduce = ?, mail = ?, phoneNumber = ?, gender = ?, major = ? WHERE idx = ?";

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
			pstmt.setString(9, idx);

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

	/*	*/
	public String getMyData(String idx, String keyword) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM userTable WHERE idx='" + idx + "'");
			String returnData = null;
			while (rs.next()) {
				returnData = rs.getString(keyword);
			}
			conn.close();
			return returnData;
		} catch (Exception e) {
		}

		return null;
	}

	/*	*/
	public String getMyDataIdx(String idx, String keyword) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM boardtable WHERE idx='" + idx + "'");
			String returnData = null;
			while (rs.next()) {
				returnData = rs.getString(keyword);
			}
			conn.close();
			return returnData;
		} catch (Exception e) {
		}

		return null;
	}

}
