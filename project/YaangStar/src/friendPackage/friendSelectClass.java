package friendPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;

public class friendSelectClass {
	
	public String[] followList(HttpServletRequest request) {
		String list_followers[] = new String[5];
		HttpSession session = request.getSession();
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM friendTable where follow = "
					+ session.getAttribute("logOK") + " and suggestion = 'true' ORDER BY idx DESC");
			int i = 0;
			while (rs.next()) {
				list_followers[i] = rs.getString("followers");
				i++;
			}

		} catch (Exception e) {
		}

		return list_followers;
	}

	public String[] followersList(HttpServletRequest request) {
		String list_follow[] = new String[5];
		HttpSession session = request.getSession();
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM friendTable where followers = "
					+ session.getAttribute("logOK") + " and suggestion = 'true' ORDER BY idx DESC");
			int i = 0;
			while (rs.next()) {
				list_follow[i] = rs.getString("follow");
				i++;
			}

		} catch (Exception e) {
		}

		return list_follow;
	}

}
