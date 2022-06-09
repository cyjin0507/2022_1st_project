<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
PrintWriter outs= response.getWriter();

HttpSession s = request.getSession();
String id = (String)s.getAttribute("logOK");

if(!id.isEmpty()) {
	outs.print("<script>window.location.href='./main.jsp'</script>");
} else {
	outs.print("<script>window.location.href='./intro.jsp'</script>");
}

%>