package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import common.JdbcUtil;

public class test_2 {
	public String[] idx_list() {
		String[] list_idx = new String[100];

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM boardtable ORDER BY idx DESC");

			int i = 0;

			while (rs.next()) {
				list_idx[i] = rs.getString("idx");
				i++;
			}
		} catch (Exception e) {
		}

		return list_idx;
	}
	
	
	public String[] uidx_list() {
		String[] list_uidx = new String[100];

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();

			// 최근에 넣은 idx 값 가져 오기
			ResultSet rs = stmt.executeQuery("SELECT * FROM boardtable ORDER BY idx DESC");

			int i = 0;

			while (rs.next()) {
				list_uidx[i] = rs.getString("uidx");
				i++;
			}
			
		} catch (Exception e) {
		}

		return list_uidx;
	}
}
