<%@page import="common.MemberDAO"%>
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
		String id, pw, name, nickname, major, type, gender;
		MemberDAO dao = new MemberDAO();
		int n = 0;

		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		nickname = request.getParameter("nickname");
		major = request.getParameter("major");
		//type = request.

		n = dao.insertMember(id, pw, name, nickname, major);

		if (n > 0)
			response.sendRedirect("resultScreen.jsp");
		else
			out.print("버그");
			out.print("<script> History.back() </script>");
	%>
</body>
</html>