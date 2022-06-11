package userController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcUtil;
import dao.MemberDAO;

public class myBoard {
	
	public String[] myBoardRetrun(String idx) {
		try {
			 MemberDAO dao = new MemberDAO();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("select * from boardTable WHERE uidx='" + idx + "'");
			String[] myArr = new String[1000];
			int i =0;
			
			while(rs.next()) {
				myArr[i] = rs.getString("userContent");
			}
			System.out.println(myArr);
			
		} catch (Exception e) {
		}
		return null;
		
		
	}

}
