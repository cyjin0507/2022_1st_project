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
	String id = (String)session.getAttribute("logOK");

	if(id!=null){
		System.out.println("넘어가");
		session.removeAttribute("logOK");
		response.sendRedirect("./index.jsp");
	} else {
		out.println("<script> alert(\"로그인 상태가 아닙니다.\"); </script>");
	}
%>
</body>
</html>