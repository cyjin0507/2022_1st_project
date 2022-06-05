<%@page import="common.MemberDAO"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
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

		int idx = 0;
		MemberDAO dao = new MemberDAO();

		idx = dao.getLastIdxUser();

		//가장 최근에 올린 idx
		ResultSet rs = stmt.executeQuery("select image from boardTable where idx = " + idx);
		String image;

		while (rs.next()) {
			out.print("프사 경로 : " + rs.getString("image"));
			%><br><%
			image = rs.getString("image");
	%>

	<img alt="dsfas" src="<%=image%>">

	<%
		}
		stmt.close();
		conn.close();
	%>
	<br>
	<Br>

	<a href="/login/index.jsp">돌아가기</a>
</body>
</html>