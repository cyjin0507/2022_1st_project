<%@page import="common.MemberDAO"%>
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
		String userProfile;
		int idx = 0;
		int d = 0;

		MemberDAO dao = new MemberDAO();

		//String n = "C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/image";
		MultipartRequest mr = new MultipartRequest(request,
				"C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/image_test",
				1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		String fileName = mr.getFilesystemName("image");
		System.out.println("\n사진 이름 : " + fileName);

		userProfile = "/image_test/"
				+ fileName;
		idx = 1;

		System.out.print("\n이미지 경로 : " + userProfile);
		d = dao.inserProfile(userProfile, idx);
		
		if (d > 0) {
			response.sendRedirect("/profileUpload/userProfileReultScreen.jsp");
		} else
			out.print("버그");
		out.print("<script> History.back() </script>");
	%>

</body>
</html>