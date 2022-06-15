package recordPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.JdbcUtil;

public class recordDAO {
	public int getLastIdxRecord() {
		int a = 0;

		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 recordTable idx 값 가져 오기
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM recordTable");

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
		String sql = "INSERT INTO recordTable VALUES(?,?,?)";

		conn = JdbcUtil.getConnection(); // JDBC 드라이버 메모리 로딩, DB연결
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx); // idx +1
			pstmt.setString(2, uidx); // 내 아이디 세션
			pstmt.setString(3, bidx);// 게시물 세션

			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;

	}

	public String[] doubleCheck(String uidx, String bidx) {
		String[] rsDeList = new String[3];
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();
			
			ResultSet rs, rsDe;
			rs = stmt.executeQuery(
					"select * from recordTable where uidx=" + uidx + " and bidx = " + bidx + " ORDER by idx asc");

			int i = 0;
			while (rs.next()) {
				rsDeList[i] = rs.getString("idx");
				i++;
			}
			
			if(i > 1) {
				rsDe = stmt.executeQuery(
						"DELETE FROM recordTable WHERE idx = "+rsDeList[1]);
			}
			conn.close();
		} catch (Exception e) {
		}

		return rsDeList;
	}
	
	public ArrayList<String> record_list(String bidx) {
		// 좋아요 계속 받아오기
		ArrayList<String> recordList = new ArrayList<String>();

		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from recordTable where bidx=" + bidx + " ORDER by idx desc");

			while (rs.next()) {
				// 위 배열에 값을 넣어준다.
				recordList.add(rs.getString("idx"));
			}
			conn.close();
			// 배열을 리턴
			return recordList;
		} catch (Exception e) {
		}
		return null;
	}

}
