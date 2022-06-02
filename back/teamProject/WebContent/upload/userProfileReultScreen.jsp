<%@page import="common.MemberDAO"%>
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
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = JdbcUtil.getConnection();

		Statement stmt = conn.createStatement();

		int idx = 0;
		MemberDAO dao = new MemberDAO();

		idx = dao.getLastNumber();

		//가장 최근에 올린 idx
		ResultSet rs = stmt.executeQuery("select userProfile from userTable where idx = " + idx);
		String userProfile;

		while (rs.next()) {
			System.out.print("\n프사 경로 : " + rs.getString("userProfile"));
			userProfile = rs.getString("userProfile");
	%>

	<img alt="dsfas" src="<%=userProfile%>">

	<%
		}
		stmt.close();
		conn.close();
	%>
	<br>
	<br>
	<a href="/login/index.jsp">돌아가기</a>
</body>
</html>