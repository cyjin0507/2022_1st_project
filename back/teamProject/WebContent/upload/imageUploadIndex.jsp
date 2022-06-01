
<%@page import="org.w3c.dom.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<textarea rows="10" cols="30" name="content" placeholder="내용 입력"></textarea><br>
<input type="file" name="inputImage">
<button name="sendButton">보내기</button>
<img alt="" src="" class="uploadImage">

<%

%>
<br><br>
<a href="/login/index.jsp">돌아가기</a>
</body>
</html>