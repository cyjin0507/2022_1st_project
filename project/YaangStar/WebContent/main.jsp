<%@page import="selectPackage.YourBorad"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp"/>	


<%
HttpSession s = request.getSession();

MemberDAO dao = new MemberDAO();
%>

    <!-- SECTION -->
    <section id="main-page">
    <%
            	YourBorad youB = new YourBorad();
 				String[] boardArr = youB.yourBoardRetrun(dao.getMyData((String)s.getAttribute("logOK"), "idx"));
 				String idx = dao.getMyData((String)s.getAttribute("logOK"), "idx");
 				for(int i=0; i<=100; i++) {
 					if(boardArr[i] == null) {
 					
 	 					break;
 					}
 					
 					%>
        <div id="board-page">
            <div class="board">
                <div class="user-info">
                    <img src="<%= dao.getMyData(게시물 올린 사람 이름, "userprofile") %>" alt="" class="user-img">
                    <div><%= dao.getMyData(게시물 올린 사람 이름, "username") %></div>
                </div>
                <img src="" alt="" class="board-img">
                <div class="board-content">
                    <div class="board-icons">
                        <i class="fa-solid fa-heart"></i>
                        <i class="fa-solid fa-comment"></i>
                    </div>
                    <div class="board-like">좋아요 934개</div>
                    <div class="content">
                        하하하하ㅏ하ㅏ하ㅏ하하하하하 <br>
                        하하하하ㅏ하ㅏ하ㅏ하 <br>
                        하하하하ㅏ하ㅏ하ㅏ하하하 <br>
                        하하하하
                    </div>
                    <div class="tage">
                        #하하하#하하하핳<br>
                        #하하하glglg#하하하핳
                    </div>
                    <div class="comment">
                        댓글 19개 모두 보기
                    </div>
                    <div class="time">1시간 전</div>
                    <form class="comment-area" action="/commentInsert" method="post">
                        <i class="fa-solid fa-face-smile"></i>
                        <input type="text" placeholder="댓글 달기..." name="commentContent">
                        <button type="submit">게시</button>
                    </form>
                </div>
            </div>
         </div>
  <%
 				}
            %>

        <div id="user-info">
            <div id="my-info">
                <img src=" <%= dao.getMyData((String)s.getAttribute("logOK"), "userprofile") %> " alt="" id="my-profile">
                <div>   
                    <div> <%= dao.getMyData((String)s.getAttribute("logOK"), "username") %> </div>
                    <div> <%= dao.getMyData((String)s.getAttribute("logOK"), "nickname") %></div>
                </div>
            </div>
            <div id="list-info">
                <div>회원님을 위한 추천</div>
                <div>모두 보기</div>
            </div>
            <div id="friend-list">
                <div class="list-detail">
                    <div>
                        <img src="data:image/jpeg;base64,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" alt="" class="friend-profile">
                        <div>친구친구</div>
                    </div>
                    <a href="/friendAdd?id=13">팔로우</a>
                </div>
                <div class="list-detail">
                    <div>
                        <img src="data:image/jpeg;base64,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" alt="" class="friend-profile">
                        <div>친구친구</div>
                    </div>
                    <a href="/test.html?id=12">팔로우</a>
                </div>
                <div class="list-detail">
                    <div>
                        <img src="data:image/jpeg;base64,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" alt="" class="friend-profile">
                        <div>친구친구</div>
                    </div>
                    <a href="">팔로우</a>
                </div>
                <div class="list-detail">
                    <div>
                        <img src="data:image/jpeg;base64,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" alt="" class="friend-profile">
                        <div>친구친구</div>
                    </div>
                    <a href="">팔로우</a>
                </div>
            </div>

            <footer>
                CopyRight (C) Yaang Star 2022 All Right Reserved.
            </footer>

        </div>

    </section>


<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/board.js"></script>
</body>
</html>