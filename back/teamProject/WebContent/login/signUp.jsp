<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="signUpProc.jsp" method="post">
id : <input type="text" name="id"><br>
pw : <input type="password" name="pw"><br>
이름 : <input type="text" name="name"><br>
닉네임 : <input type="text" name="nickname"><br>
전공 : <input type="text" name="major"><br>
성별 : <input type="radio" name="gender" value="he">남성&nbsp;
<input type="radio" value="she" name="gender">여성<br>
직급? : <input type="radio" name="type" value="student">학생&nbsp;<input type="radio" name="type" value="teacher">교사<br>

<input type="submit" value="회원가입">&nbsp;&nbsp;<input type="reset" value="취소"><br>
</form><br>

<a href="./index.jsp">돌아가기</a>
</body>
</html>