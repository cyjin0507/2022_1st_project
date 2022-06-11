package selectPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;

public class YourBorad {

	public String[] yourIdxBoardRetrun() {
		HttpServletRequest request = null;
		String[] list_idx = new String[100];
		HttpSession session = request.getSession();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			String not = (String) session.getAttribute("logOK");

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM boardtable where idx > 0 and  uidx != '" + not + " ' ORDER BY idx DESC");

			int i = 0;

			while (rs.next()) {
				list_idx[i] = rs.getString("idx");
				i++;
			}
		} catch (Exception e) {
		}

		return list_idx;
	}

	public String[] yourUidxBoardRetrun() {
		HttpServletRequest request = null;
		String[] list_uidx = new String[100];
		HttpSession session = request.getSession();
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			String not = (String) session.getAttribute("logOK");

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM boardtable where idx > 0 and  uidx != '" + not + " ' ORDER BY idx DESC");

			int i = 0;

			while (rs.next()) {
				list_uidx[i] = rs.getString("uidx");
				i++;
			}
		} catch (Exception e) {
		}

		return list_uidx;
	}

	public String yourBorad(String idx, String keyWord) {
		HttpServletRequest request = null;
		String retrunData = null;
		HttpSession session = request.getSession();
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			String not = (String) session.getAttribute("logOK");

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM boardtable where idx > 0 and  uidx != '" + not + " ' ORDER BY idx DESC");

			while (rs.next()) {
				retrunData = rs.getString(keyWord);
			}

		} catch (Exception e) {
		}

		return retrunData;
	}
}
