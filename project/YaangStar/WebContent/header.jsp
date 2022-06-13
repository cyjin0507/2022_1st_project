<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%
MemberDAO dao = new MemberDAO();
HttpSession s = request.getSession();
%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/template.css">
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/sub.css">
    <link rel="stylesheet" href="./resources/fontawesome-free-6.1.1-web/fontawesome-free-6.1.1-web/css/all.min.css">
    <title>Yaang Star</title>
</head>

<body>
    <div class="popup" id="pop1">
        <div id="board-popup">
            <div>새 게시글 만들기
                <a href="#">&#10005;</a>
            </div>
            <form action="/boardInsert" method="post" enctype="multipart/form-data">
                <div id="board-img">
                    <i class="fa-solid fa-images"></i>
                    <div>사진과 동영상을 선택해주세요</div>
                    <input type="file" id="imgFile" name="image">
                    <label for="imgFile">컴퓨터에서 선택</label>
                </div>
                <div id="board-input">
                    <div>
                        <img src="<%= dao.getMyData((String)s.getAttribute("logOK"), "userProfile") %>" alt="">
                        <div><%= dao.getMyData((String)s.getAttribute("logOK"), "username") %></div>
                    </div>
                    <textarea cols="30" rows="10" required class="content-textarea" name="content" placeholder="게시글 입력..."></textarea>
                    <textarea cols="30" rows="10" required class="tage-textarea" name="userTage" placeholder="태그 입력..."></textarea>
                    <button class="board-btn">작성하기</button>
                </div>
            </form>
        </div>
    </div>

    <!-- <div class="popup" id="pop2">
        <div id="follow-popup">
            <div>팔로우 요청</div>
            <div>

            </div>
        </div>
    </div> -->
    



    <!-- 헤더 -->
    <header>
        <div id="header">
            <a href="index.jsp"><img src="./resources/imgs/logo-b.png" alt="" id="logo"></a>
           	<form action="./friendPage.jsp" method="get">
           		<input type="text" name="keyWord" placeholder="검색어를 입력하세요.">
           	</form>
            <nav>
                <a href="./main.jsp"><i class="fa-solid fa-house"></i></a>
                <a href="#pop1"><i class="fa-solid fa-square-plus"></i></a>
                <a href=""><i class="fa-solid fa-heart"></i></a>
                <div id="user-pop">
                    <i class="fa-solid fa-circle-user"></i>
                    <div id="user-info-pop">
                        <div id="user-info-pop-inner">
                            <div id="pop-user-name"><%= dao.getMyData((String)s.getAttribute("logOK"), "username") %></div>
                            <div class="user-pop-info"><a href="./myPage.jsp">회원정보</a></div>
                            <div class="user-pop-info"><a href="./logOut.jsp" style="color:red">로그아웃</a></div>
                        </div>
                    </div>
                </div>
                
            </nav>
        </div>
    </header>