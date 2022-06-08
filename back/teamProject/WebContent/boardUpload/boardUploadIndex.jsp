<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="Action_" action="<%=request.getContextPath()%>/boardUpload/boardContentUpload.jsp" method="post" enctype="multipart/form-data">
		<div class="form-group">
	        사진 : 
	        <input type="file" name="image">
	    </div>
	    
	    <button id="btn" type="submit">추가</button>
	</form>
	


	<br>
	<Br>

	<a href="/login/index.jsp">돌아가기</a>
</body>
</html>