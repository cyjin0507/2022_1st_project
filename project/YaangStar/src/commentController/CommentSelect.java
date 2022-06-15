package commentController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcUtil;

public class CommentSelect {

	// 댓글이 어느 게시물의 댓글인지 알려주는 함수
	public String[] CommentBidx(String bidx) {
		// 댓글의 갯수를 임의로 1000개라고 정한다
		String[] list_bidx = new String[1000];

		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt
					.executeQuery("select * from commentTable where bidx=" + bidx + " ORDER by idx desc");

			int i = 0;
			while (rs.next()) {
				// 위 배열에 값을 넣어준다.
				list_bidx[i] = rs.getString("uidx");
				i++;
			}
			conn.close();
			// 배열을 리턴
			return list_bidx;
		} catch (Exception e) {
		}
		return null;
	}

	// 댓글에 필요한 부분을 리턴해준다.
	public String comment(String idx, String keyWord) {
		String retrunData = null;
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt
					.executeQuery("select * from commentTable where bidx=" + idx + " ORDER by idx desc");
			
			while (rs.next()) {
				retrunData = rs.getString(keyWord);
			}
			conn.close();
		} catch (Exception e) {
		}

		return retrunData;
	}

}
