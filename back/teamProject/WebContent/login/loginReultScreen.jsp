<%@page import="common.MemberDAO"%>
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

		String url = "jdbc:oracle:thin:@pukkuk.pp.ua:49161:xe";
		Connection conn = JdbcUtil.getConnection();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from userTable where idx > 0");
		
		while (rs.next()) {
			System.out.println("test_rs");
			out.print("idx : " + rs.getString("idx") + "\tid: " + rs.getString(2) + "\t비번 : " + rs.getString(3)
					+ "\t이름 : " + rs.getString(4) + "\t닉네임 : " + rs.getString(5) + "\t전공 : " + rs.getString(6)
					+ "\t직위? : " + rs.getString(7) + "\t성별 : " + rs.getString(8) + "\t날짜 : " + rs.getString(9)
					+ "\t프사 경로 : " + rs.getString(10)+"<br>");
		}
		
		ResultSet rs_2 = stmt.executeQuery("select idx, userProfile from userTable where idx > 0");
		
		while (rs_2.next()) {
			System.out.println("test_rs_2");
			out.print("idx : " + rs_2.getString("idx"));
			%>
			<img alt="" src="<%=rs_2.getString("userProfile")%>"><br>
			<%
		}

		//response.sendRedirect("/upload/imageUploadIndex.jsp");
		stmt.close();
		conn.close(); 
		
		%><br><Br>
	<a href="/login/index.jsp">돌아가기</a>
</body>
</html>