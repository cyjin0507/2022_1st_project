<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.Date"%>
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
			String image, tage, userContent, reserved1, reserved2;

			int idx;
			int uidx = 0;
			int c = 0;

			MemberDAO dao = new MemberDAO();
			Date create_date;
			create_date = dao.myDate();

			idx = dao.getLastIdxBoard() + 1;
			uidx = dao.getLastUidxBoard() + 1;

			//이미지 넣는거
			MultipartRequest mr = new MultipartRequest(request,
					"C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/imageBoard",
					1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

			String fileName = mr.getFilesystemName("image");
			System.out.println("사진 이름 : " + fileName);

			image = "/imageBoard/" + fileName;
			System.out.println("이미지 경로 : " + image);

			tage = "";
			userContent = "";

			reserved1 = "";
			reserved2 = "";
	
			System.out.println("idx : " + idx);
			System.out.println("uidx : " + uidx);

			c = dao.insertBoard(idx, uidx, tage, userContent, image, create_date, reserved1, reserved2);

			if (c < 0){
				out.print("버그");
			out.print("<script> History.back() </script>");
			}else
				response.sendRedirect("/boardUpload/boardUploadProc.jsp");
		%>


	<br>
	<Br>

	<a href="/login/index.jsp">취소</a>
</body>
</html>