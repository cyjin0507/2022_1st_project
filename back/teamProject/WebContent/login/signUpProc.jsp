<%@page import="java.util.Date"%>
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
		int idx = 0;
		String userId, userPassword, userName, nickname, major, userType, gender, start_date, reserved1, reserved2;
		MemberDAO dao = new MemberDAO();
		Date date;
		date = dao.myDate();
		int n = 0;
		idx = dao.getLastNumber() + 1;
		userId = request.getParameter("userId");
		userPassword = request.getParameter("userPassword");
		userName = request.getParameter("userName");
		nickname = request.getParameter("nickname");
		major = request.getParameter("major");
		userType = request.getParameter("userType");
		gender = request.getParameter("gender");

		reserved1 = "a";
		reserved2 = "b";

		n = dao.insertMember(idx, userId, userPassword, userName, nickname, major, userType, gender, date,
				reserved1, reserved2);
		if (n > 0)
			response.sendRedirect("/login/reultScreen.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");
	%>

</body>
</html>