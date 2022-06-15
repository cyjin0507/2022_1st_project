<%@page import="friendPackage.friendSelectClass"%>
<%@page import="userController.friendSelect"%>
<%@page import="userController.myBoard"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberDAO dao = new MemberDAO();
	friendSelectClass friend = new friendSelectClass();

	String[] followers_list = friend.followersList(request);
	String[] follow_list = friend.followList(request);

	int i = 0;
%>

<div class="popup" id="follower">
	<div class="follow-popup">
		<div>
			팔로우 <a href="#">&#10005;</a>
		</div>
		<div class="follow-list">

			<%
				int followers_i = 0;
				for (followers_i = 0; followers_i < followers_list.length; followers_i++) {
					if (followers_list[followers_i] == null) {
						break;
					}
				}

				for (i = 0; i < followers_list.length; i++) {
					if (followers_list[i] != null) {
			%>

			<div>
				<div>
					<img src="<%=dao.getMyData(followers_list[i], "userProfile")%>"
						alt="">
					<div>
						<div><%=dao.getMyData(followers_list[i], "nickname")%></div>
						<div><%=dao.getMyData(followers_list[i], "username")%></div>
					</div>
				</div>
				<a href="">삭제</a>
			</div>
			<%
				}
				}
			%>
		</div>
	</div>
</div>

<div class="popup" id="follow">
	<div class="follow-popup">
		<%
			int follow_i = 0;
			for (follow_i = 0; follow_i < follow_list.length; follow_i++) {
				if (follow_list[follow_i] == null) {
					break;
				}
			}
		%>
		<div>
			팔로워 <a href="#">&#10005;</a>
		</div>
		<div class="follow-list">
			<%
				for (i = 0; i < follow_list.length; i++) {
					if (follow_list[i] != null) {
			%>

			<div>
				<div>
					<img src="<%=dao.getMyData(follow_list[i], "userProfile")%>" alt="">
					<div>
						<div><%=dao.getMyData(follow_list[i], "nickname")%></div>
						<div><%=dao.getMyData(follow_list[i], "username")%></div>
					</div>
				</div>

			</div>
			<%
				}
				}
			%>
		</div>
	</div>
</div>


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
%>



<section id="myPage">
	<div id="my-detail-info">
		<%
			int borad_i = 0;
			myBoard myB = new myBoard();
			String[] boardArr = myB.myBoardRetrun(dao.getMyData((String) s.getAttribute("logOK"), "idx"));
			for (borad_i = 0; borad_i < boardArr.length; borad_i++) {
				if (boardArr[borad_i] == null) {
					break;
				}
			}
		%>
		<img
			src="<%=dao.getMyData((String) s.getAttribute("logOK"), "userprofile")%>"
			alt="" class="my-profile-img">
		<div>
			<div>
				<div><%=dao.getMyData((String) s.getAttribute("logOK"), "username")%></div>
				<a href="./userController.jsp">프로필 편집</a>
			</div>
			<div>
				<div>
					게시물
					<%=borad_i%></div>
				<div>
					<a href="#follow">팔로워 <%=follow_i%></a>
				</div>
				<div>
					<a href="#follower">팔로우 <%=followers_i%></a>
				</div>
			</div>
			<div>
				<%=dao.getMyData((String) s.getAttribute("logOK"), "introduce")%>
			</div>
		</div>
	</div>
	<div id="my-infos">
		<div>게시물</div>
		<div>
			<%
				String idx = dao.getMyData((String) s.getAttribute("logOK"), "idx");
				for (i = 0; i <= 100; i++) {
					if (boardArr[i] == null) {
						break;
					}
			%>

			<!-- get image -->
			<div class="board-img">
				<img src="<%=myB.myboard(boardArr[i], "image")%>"
					class="my-board-img" alt="">
				<div>
					<a href="/BoardRemove?idx=<%=myB.myboard(boardArr[i], "idx")%>">&#10005;</a>
					<div><%=myB.myboard(boardArr[i], "userContent")%></div>
				</div>
			</div>
			<%
				}
			%>

		</div>
	</div>
</section>
<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/board.js"></script>
</body>

</html>