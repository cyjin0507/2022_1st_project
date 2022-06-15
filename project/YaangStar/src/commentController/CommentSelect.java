package commentController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcUtil;

public class CommentSelect {

	public String[] CommentBidx(String bidx) {
		String[] list_bidx = new String[1000];

		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt
					.executeQuery("select * from commentTable where bidx=" + bidx + " ORDER by idx DESC");
			
			int i = 0;
			while (rs.next()) {
				list_bidx[i] = rs.getString("idx"); 
				i++;
			}
			conn.close();
		} catch (Exception e) {
		}
	return list_bidx;
	}
	
	public String comment(String bidx, String keyWord) {
		String retrunData = null;
		try {

			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from commenttable WHERE bidx=" + bidx + " ORDER by idx DESC");

			while (rs.next()) {
				retrunData = rs.getString(keyWord);
			}
			conn.close();
		} catch (Exception e) {
		}

		return retrunData;
	}

}
