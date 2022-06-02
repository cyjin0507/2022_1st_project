<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<!-- request 대신 -->
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//String n = "C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/image";
		// 웹 프로젝트 위치에 넣어도 된다 (이클립스에서 사진 추가되는 것을 실시간으로 확인 가능)
		MultipartRequest mr = new MultipartRequest(request,
				"C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/image_test",
				1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		System.out.println("저장되는 경로(실제 서버) : " + mr);

		String fileName = mr.getFilesystemName("image");
		System.out.println("사진 이름 : " + fileName);
	%>
	<img alt="몰루?" src="C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/image_test/<%=fileName%>">
	<br><br>
<a href="/login/index.jsp">돌아가기</a>
</body>
</html>