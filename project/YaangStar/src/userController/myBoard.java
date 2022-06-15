package userController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcUtil;
import dao.MemberDAO;

public class myBoard {

	public String[] myBoardRetrun(String idx) {
		String[] myArr = new String[1000];
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select * from boardTable WHERE uidx='" + idx + "' ORDER BY idx DESC");

			int i = 0;

			while (rs.next()) {
				myArr[i] = rs.getString("idx");
				i++;
			}

		} catch (Exception e) {
		}

		return myArr;

	}

	public String myboard(String idx, String keyWord) {
		String retrunData = null;
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from boardTable WHERE idx='" + idx + "'");

			while (rs.next()) {
				retrunData = rs.getString(keyWord);
			}
		} catch (Exception e) {
		}

		return retrunData;
	}

}
