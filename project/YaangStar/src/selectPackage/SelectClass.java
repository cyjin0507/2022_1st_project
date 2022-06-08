package selectPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcUtil;

public class SelectClass {
	public int setBoard() {

		int n = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs, rs_1;

			// 최근에 넣은 idx 값 가져 오기
			rs = stmt.executeQuery("SELECT userProfile FROM usertable where 0");

			while (rs.next()) {
				System.out.println("불러오기 성공");
				n = rs.getInt("userProfile");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("불러오기 실패");
		}
		return n;

	}
}
