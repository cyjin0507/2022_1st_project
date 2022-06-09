<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>following friends</title>
</head>
<body>
	<a href="follow.jsp; ?id=13">test</a>
	<%
		//JDBC 드라이버 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		// db 서버 접속
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection conn = DriverManager.getConnection(url, "hr", "hr");
		
		//stmt or pstmt 객체 생성
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("create table userTable(id varchar2(5))");
		
		stmt.close();
		conn.close();
		
	%>

</body>
</html>