<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/user.css">
    <title>로그인</title>
</head>
<body>

    <form id="login-box" method="post" action="/Login">
        <h2>LOGIN</h2>
        <div id="login-area">
            <div class="login-input">
                <div>아이디</div>
                <input type="text" placeholder="아이디를 입력해주세요" name="userId">
            </div>
            <div class="login-input">
                <div>비밀번호</div>
                <input type="password" placeholder="비밀번호를 입력해주세요" name="userPassword">
            </div>
            <button class="login-btn">로그인</button>
            <div id="login-help">
                <a href="join.jsp">아직 회원이 아니신가요?</a>
            </div>
        </div>
    </form>
    
</body>
</html>