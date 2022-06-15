package friendPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;

public class friendSelectClass {
	
	public String[] followList(HttpServletRequest request) {
		//배열로 팔로워 값 넣어주기
		String list_followers[] = new String[5];
		//세션 불러오기
		HttpSession session = request.getSession();
		try {
			//커넥션 연결
			Connection conn = JdbcUtil.getConnection();
			//statement 인스턴스생성
			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM friendTable where follow = "
					+ session.getAttribute("logOK") + " and suggestion = 'true' ORDER BY idx DESC");
			int i = 0;
			while (rs.next()) {
				list_followers[i] = rs.getString("followers");
				i++;
			}
			conn.close();
		} catch (Exception e) {
		}

		return list_followers;
	}

	public String[] followersList(HttpServletRequest request) {
		//배열로 팔로우 값 넣어주기
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
			conn.close();
		} catch (Exception e) {
		}

		return list_follow;
	}
	
	public String[] followersIdxList(HttpServletRequest request) {
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
				list_follow[i] = rs.getString("idx");
				i++;
			}
			conn.close();
		} catch (Exception e) {
		}

		return list_follow;
	}

}
