<%@page import="common.JdbcUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = JdbcUtil.getConnection();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from userTable");

		while (rs.next()) {
			out.print("id : " + rs.getString("id") + "\tpw : " + rs.getString(2) + "\t이름 : " + rs.getString(3)
					+ "\t닉네임 : " + rs.getString(4) + "\t전공 : " + rs.getString(5) + "\t" + "<br>");
		}

		stmt.close();
		conn.close();
	%>
</body>
</html>