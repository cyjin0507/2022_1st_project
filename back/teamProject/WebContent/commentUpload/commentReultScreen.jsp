<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JdbcUtil"%>
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

		String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
		Connection conn = JdbcUtil.getConnection();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from commenttable where idx > 0");

		while (rs.next()) {
			System.out.println("test_rs_commenttable");
			out.print("idx : " + rs.getString("idx") + "\tcommentContent : " + rs.getString(4) + "<br>");
		}

		stmt.close();
		conn.close();
	%>
	<br>
	<Br>
	<a href="/login/index.jsp">돌아가기</a>
</body>
</html>