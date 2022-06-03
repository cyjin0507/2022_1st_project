<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String board;
		int idx = 0;
		int d = 0;

		MemberDAO dao = new MemberDAO();

		MultipartRequest mr = new MultipartRequest(request,
				"C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/imageBoard",
				1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		String fileName = mr.getFilesystemName("image");
		System.out.println("\n사진 이름 : " + fileName);

		board = "/imageBoard/"
				+ fileName;
		idx = 1;

		System.out.print("\n이미지 경로 : " + board);
		d = dao.inserProfile(board, idx);
		
		if (d > 0) 
			response.sendRedirect("/boardUpload/boardReultScreen.jsp");
		 else
			out.print("버그");
		out.print("<script> History.back() </script>");
	%>
</body>
</html>