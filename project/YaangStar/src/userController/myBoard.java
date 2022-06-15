package userController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcUtil;

public class myBoard {

	// 내 게시물의 idx값을 배열에 담아서 리턴해주는 함수
	public String[] myBoardRetrun(String idx) {
		// 게시물의 갯수를 1000개로 가정함
		String[] myArr = new String[1000];
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select * from boardTable WHERE uidx='" + idx + "' ORDER BY idx DESC");

			int i = 0;

			while (rs.next()) {
				// 위 배열에 값을 담는다
				myArr[i] = rs.getString("idx");
				i++;
			}

		} catch (Exception e) {
		}

		// 배열을 리턴해준다.
		return myArr;

	}

	// idx값을 받아 원하는 컬럼의 값을 리턴해주는 함수
	public String myboard(String idx, String keyWord) {
		String retrunData = null;
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from boardTable WHERE idx='" + idx + "'");

			while (rs.next()) {
				retrunData = rs.getString(keyWord);
			}
			conn.close();
		} catch (Exception e) {
		}

		return retrunData;
	}

}
