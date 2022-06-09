<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
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


long time = System.currentTimeMillis();
System.out.println(time);
SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddaahhmmss");
String s = simpl.format(time) + (int)(Math.random()*100);
%>

<%= s %>

</body>
</html>