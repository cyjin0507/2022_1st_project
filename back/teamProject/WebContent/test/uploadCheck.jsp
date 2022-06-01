<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
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
<%
    String path = request.getRealPath("uploadedFiles");
    int size = 1024 * 1024 * 20; //20MB
    String str, filename, original_filename;
    try{//몰루
    	MultipartRequest multiRequest = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
    	
    	Enumeration files = multiRequest.getFileNames();
    	str = (String)files.nextElement();
    	filename = multiRequest.getFilesystemName(str);
    	original_filename = multiRequest.getOriginalFileName(str);
    	
    	System.out.println("str : "+str);
    	System.out.println("filename : "+filename);
    	System.out.println("original_filename : "+original_filename);
    } catch (Exception e){
    	e.printStackTrace();
    }
%>
</body>
</html>