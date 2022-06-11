<%@page import="test.test_2"%>
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
		test_2 t = new test_2();

		String[] s_list = t.idx_list();
		String[] u_list = t.uidx_list();

		for (int i = 0; i <= 100; i++) {
			if (s_list[i] == null) {

				break;
			}
	%>
	<%=s_list[i]%>
	<%
		}
	%><BR>
	<%
		for (int i = 0; i <= 100; i++) {
			if (u_list[i] == null) {

				break;
			}
	%>
	<%=u_list[i]%>
	<%
		}
	%>
</body>
</html>