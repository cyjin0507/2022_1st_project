package userController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;

public class friendSelect {

	// 친구의 이름을 가지고 그 친구의 idx값을 리턴해주는 함수
	public int friendSelect(String name) {

		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select * from userTable where userName = '" + name + "'");

			while (rs.next()) {
				// 하나의 데이터만 필요하기 때문에 여기서 idx값을 리턴해준다.
				return rs.getInt("idx");
			}
			conn.close();
		} catch (Exception e) {
		}

		return -1;
	}

	// 친구의 이름으로 위 함수에서 idx값을 리턴 받은 뒤에 워하는 값을 keyWord로 넘겨주어 원하는 값을 return한다.
	public String friend(String name, String keyWord) {

		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select * from userTable where idx=" + friendSelect(name));

			while (rs.next()) {
				// 원하는 값을 keyWord로 받아 리턴해준다.
				return rs.getString(keyWord);
			}
			conn.close();
		} catch (Exception e) {
		}

		return null;
	}

	// 메인페이지에서 추천 친구리스트 5개를 띄워주는 함수
	public String[] friendList(HttpServletRequest request) {
		// 5개이므ㄹ오 크기가 5인 배열을 만든다.
		String nList[] = new String[5];
		HttpSession session = request.getSession();
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select idx from userTable where idx > 0 and idx != "
					+ session.getAttribute("logOK") + " order by dbms_random.random()");
			int i = 0;
			while (rs.next()) {
				// 위 배열에 하나씩 idx값을 담는다.
				nList[i] = rs.getString("idx");
				i++;
			}
			conn.close();
		} catch (Exception e) {
		}

		// 이후 배열을 리턴해준다.
		return nList;
	}
}
