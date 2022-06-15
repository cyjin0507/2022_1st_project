<%@page import="commentController.CommentSelect"%>
<%@page import="userController.friendSelect"%>
<%@page import="java.util.Random"%>
<%@page import="commentController.CommentInsert"%>
<%@page import="userController.myBoard"%>
<%@page import="userController.YourBorad"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp" />


<%
	HttpSession s = request.getSession();
	if (s.getAttribute("logOK") == null) {
%>
<script>
	alert("로그인 후 이용 가능합니다.")
	window.location.href = "./login.jsp";
</script>
<%
	}

	MemberDAO dao = new MemberDAO();
%>

<!-- SECTION -->
<section id="main-page">


	<div id="board-page">
		<%
			YourBorad youB = new YourBorad();
		CommentSelect comS = new CommentSelect();
			String[] list_youB_idx = youB.yourIdxBoardRetrun(request);
			String[] list_youB_uidx = youB.yourUidxBoardRetrun(request);

			boolean yes = false;
			for (int i = 0; i <= 100; i++) {
				if (list_youB_idx[i] == null || list_youB_uidx[i] == null) {
					break;
				}
		%>
		<div class="board">
			<div class="user-info">
				<img src="<%=dao.getMyData(list_youB_uidx[i], "userProfile")%>"
					alt="" class="user-img">
				<div><%=dao.getMyData(list_youB_uidx[i], "username")%></div>
			</div>
			<img src="<%=dao.getMyDataIdx(list_youB_idx[i], "image")%>" alt=""
				class="board-img">
			<div class="board-content">
				<div class="board-icons">
					<i class="fa-solid fa-heart heart"></i> <i
						class="fa-solid fa-comment"></i>
				</div>

				<div class="board-like">좋아요 934개</div>
				<div class="content">
					<%=dao.getMyDataIdx(list_youB_idx[i], "userContent")%>
				</div>
				<div class="tage">
					<%=dao.getMyDataIdx(list_youB_idx[i], "tage")%>
				</div>
				<div class="comment">
					<a href="#<%="comment" + i%>" <%yes = true;%>>댓글 19개 모두 보기</a>
				</div>
				
				
				</div>

				<div class="time"><%=dao.getMyDataIdx(list_youB_idx[i], "create_date")%></div>
				<form class="comment-area" action="/commentInsert" method="post">
					<i class="fa-solid fa-face-smile"></i> <input type="hidden"
						name="bidx" value="<%=list_youB_idx[i]%>"> <input
						type="text" placeholder="댓글 달기..." name="commentContent">
					<button type="submit">게시</button>
				</form>
			</div>
		<%
			}
		%>
		</div>
	</div>

	<div id="user-info">
		<div id="my-info">
			<img
				src=" <%=dao.getMyData((String) s.getAttribute("logOK"), "userprofile")%> "
				alt="" id="my-profile">
			<div>
				<div>
					<%=dao.getMyData((String) s.getAttribute("logOK"), "username")%>
				</div>
				<div>
					<%=dao.getMyData((String) s.getAttribute("logOK"), "nickname")%></div>
			</div>
		</div>

		<div id="list-info">
			<div>회원님을 위한 추천</div>
			<div>추천친구</div>
		</div>
		<%
			int n = 0;
			friendSelect fr = new friendSelect();
			String[] list = fr.friendList(request);
			Random random = new Random();
			for (int i = 0; i < 5; i++) {
				if (list[i] == null) {
					break;
				}
		%>
		<div id="friend-list">
			<div class="list-detail">
				<div>
					<img src="<%=dao.getMyData(list[i] + "", "userprofile")%>" alt=""
						class="friend-profile">
					<div><%=dao.getMyData(list[i] + "", "username")%></div>
				</div>
				<a href="/friendAdd?id=<%=dao.getMyData(list[i] + "", "idx")%>">팔로우</a>
			</div>
		</div>
 <%
			}
		%>
		<footer> CopyRight (C) Yaang Star 2022 All Right Reserved. </footer>
	</div>



</section>


<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/board.js"></script>
</body>
</html>