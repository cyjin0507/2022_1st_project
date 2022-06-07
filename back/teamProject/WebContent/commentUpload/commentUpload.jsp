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
		int uidx = 0;
		int bidx = 0;
		int s = 0;
		
		String commentContent, reserved1, reserved2;
		MemberDAO dao = new MemberDAO();
		Date create_date;
		create_date = dao.myDate();
		
		idx = dao.getLastIdxComment() + 1;
		uidx = idx;
		bidx = idx;
		
		commentContent = request.getParameter("commentContent");
		reserved1 = "";
		reserved2 = "";
		System.out.println("commentContent : " + commentContent);
		
		s = dao.insertComment(idx, uidx, bidx, commentContent, create_date, reserved1, reserved2);
		
		if (s > 0)
			response.sendRedirect("/commentUpload/commentReultScreen.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");
	%>
</body>
</html>