package userController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcUtil;

public class friendSelect {
	
	public int friendSelect(String name) {
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select * from userTable where userName = '" + name + "'");

			while (rs.next()) {
				return rs.getInt("idx");
			}

		} catch (Exception e) {
		}

		
		return -1;
	}

	public String friend(String name, String keyWord) {
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select * from userTable where idx=" + friendSelect(name));

			while (rs.next()) {
				return rs.getString(keyWord);
			}

		} catch (Exception e) {
		}

		
		return null;
	}
	
}
