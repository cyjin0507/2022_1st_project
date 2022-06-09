<%@page import="test.follow"%>
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
		String id = request.getParameter("id");
		follow insertFollow = new follow();
		insertFollow.insertFollows(userId1, userId2);
	%>
	<p> id : <%= id %>
	
</body>
</html>