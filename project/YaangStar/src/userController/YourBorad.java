package userController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;

public class YourBorad {

	// 내 게시물이 아닌 게시물을 메인페이지에 띄우는 함수
	public String[] yourIdxBoardRetrun(HttpServletRequest request) {
		String[] list_idx = new String[100];
		HttpSession session = request.getSession();

		try {

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

	// 게시물의 uidx를 리턴해주는 함수
	public String[] yourUidxBoardRetrun(HttpServletRequest request) {
		// 임의로 크기가 100인 배열을 만든다.
		String[] list_uidx = new String[100];
		HttpSession session = request.getSession();
		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			String not = (String) session.getAttribute("logOK");

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM boardtable where idx > 0 and  uidx != '" + not + " ' ORDER BY idx DESC");

			int i = 0;

			while (rs.next()) {
				// 위 배열에 uidx값을 담는다.
				list_uidx[i] = rs.getString("uidx");
				i++;
			}
		} catch (Exception e) {
		}

		// 위 배열을 리턴해준다.
		return list_uidx;
	}

	// 내 게시물이 아닌 게시물의 필요한 컬럼을 리턴해주는 함수
	public String yourBorad(HttpServletRequest request, String idx, String keyWord) {
		String retrunData = null;
		HttpSession session = request.getSession();
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			String not = (String) session.getAttribute("logOK");

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM boardtable where idx > 0 and  uidx != '" + not + " ' ORDER BY idx DESC");

			while (rs.next()) {
				retrunData = rs.getString(keyWord);
			}
			conn.close();
		} catch (Exception e) {
		}

		// 필요한 값을 리턴해준다.
		return retrunData;
	}
}
