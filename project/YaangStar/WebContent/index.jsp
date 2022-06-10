<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 자바스크립트를 쓰기 위한 스크립트릿
	PrintWriter outs = response.getWriter();

	// 세션의 정보를 받아옴
	HttpSession s = request.getSession();

	// 세션에서 logOk라는 세션 값을 id라는 변수에 담음
	String id = (String) s.getAttribute("logOK");

	// session이 있으면 즉 로그인 중이면 main.jsp로 가고 아니면 intro.jsp로 간다.
	if (id != null) {
		outs.print("<script>window.location.href=\"./main.jsp\"</script>");
	} else {
		outs.print("<script>window.location.href=\"./intro.jsp\"</script>");
	}
%>