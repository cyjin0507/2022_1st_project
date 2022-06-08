<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/user.css">
    <title>회원가입</title>
</head>
<body>

    <form action="" id="join-box">
        <h2>JOIN</h2>
        <div id="join-area">
            <div class="join-input">
                <div>이름</div>
                <input type="text">
            </div>
            <div class="join-input">
                <div>아이디</div>
                <input type="text">
            </div>
            <div class="join-input">
                <div>비밀번호</div>
                <input type="text">
            </div>
            <div class="join-input">
                <div>비밀번호 확인</div>
                <input type="text">
            </div>
            <div class="join-input">
                <div>닉네임</div>
                <input type="text">
            </div>
            <div class="join-input">
                <div>전공</div>
                <select name="" id="">
                    <option value="">선택</option>
                    <option value="">전자제어과</option>
                    <option value="">정보통신과</option>
                    <option value="">소프트웨어개발과</option>
                    <option value="">바이오화학과</option>
                    <option value="">생명정보과</option>
                </select>
            </div>
            <div id="join-btn-group">
                <button type="reset">다시작성</button>
                <button type="submit">가입하기</button>
            </div>
            <div id="join-help">
                <a href="">이미 회원이신가요?</a>
            </div>
        </div>
    </form>
    
</body>
</html>