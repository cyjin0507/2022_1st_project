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
		String tage, userContent;

		int idx = 0;
		int c = 0;

		MemberDAO dao = new MemberDAO();

		idx = dao.getLastIdxBoard();
		tage = request.getParameter("tage");
		userContent = request.getParameter("userContent");
		
		c = dao.updateContent(userContent, tage, idx);
		
		if (c > 0)
			response.sendRedirect("/boardUpload/boardReultScreen.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");
	%>
</body>
</html>