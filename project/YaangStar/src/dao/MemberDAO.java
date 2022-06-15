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
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 usrtable idx 값 가져 오기
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
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 boardTable idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM (SELECT idx FROM boardTable ORDER BY idx DESC) WHERE ROWNUM=1");

			while (rs.next()) {
				a = rs.getInt("idx");
			}
			conn.close();
			JdbcUtil.close(conn, pstmt);
		} catch (Exception e) {
		}
		return a;

	}

	public int getLastIdxComment() {
		int a = 0;

		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 commentTable idx 값 가져 오기
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

	/* 회원가입 */
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

			pstmt.setInt(1, idx); //idx 값 넣어주기 
			pstmt.setString(2, userId); //userId 값 넣어주기
			pstmt.setString(3, userPassword); //userPassword 값 넣어주기
			pstmt.setString(4, userPassword); //userPassword값 넣어주기
			pstmt.setString(5, nickname); //nickname값 넣어주기
			pstmt.setString(6, introduce); //introduce 값 넣어주기
			pstmt.setString(7, phoneNumber); //phoneNumber값 넣어주기
			pstmt.setString(8, mail); //mail값 넣어주기
			pstmt.setString(9, major); //major값 넣어주기
			pstmt.setString(10, gender); //gender값 넣어주기
			pstmt.setString(11, userProfile); //userProfile값 넣어주기
			pstmt.setString(12, reserved1); //reserved1 값 넣어주기
			pstmt.setString(13, reserved2); //reserved2 값 넣어주기

			c = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return c;
	}

	/* 게시글 등록 */
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

	/* 댓글 득록 */
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

	/* 프로필 정보 수정 */
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

	/* usertable  값 중 특정 idx 값의 정보 가져오기 */
	public String getMyData(String idx, String keyword) {
		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

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

	/* boardtable  값 중 특정 idx 값의 정보 가져오기 */
	public String getMyDataIdx(String idx, String keyword) {
		try {
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
