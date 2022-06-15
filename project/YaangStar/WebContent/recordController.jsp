<%@page import="recordPackage.recordDAO"%>
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
		HttpSession s = request.getSession();
		recordDAO dao = new recordDAO();

		String idx, uidx, bidx;
		int a = 0;

		idx = dao.getLastIdxRecord() + 1 + "";
		uidx = (String) session.getAttribute("logOK");
		bidx = request.getParameter("bidx");
		System.out.println("bidx : " + bidx);

		a = dao.insertRecord(idx, uidx, bidx);
		dao.doubleCheck(uidx, bidx);
		
		if (a > 0)
			response.sendRedirect("main.jsp");
		else {
			out.print("버그");
			response.sendRedirect("main.jsp");
		}
	%>
</body>
</html>