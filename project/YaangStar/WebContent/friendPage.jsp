<%@page import="userController.friendSelect"%>
<%@page import="userController.myBoard"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp"/>

<%
HttpSession s = request.getSession();
MemberDAO dao = new MemberDAO();
friendSelect fDao = new friendSelect();

if(s.getAttribute("logOK") == null) {
	%>
	<script>
		alert("로그인 후 이용 가능합니다.")
		window.location.href="./login.jsp";
	</script>
	<%
}

String keyWord = (String)request.getParameter("keyWord");

if(fDao.friendSelect(keyWord) == -1) {
	%>
	<script>
		alert("해당 유저는 존재하지 않습니다.")
		history.back()
		$("#header > form > input[type=text]").val("")
	</script>
	<%
}

%>


    <section id="myPage">
        <div id="my-detail-info">
            <img src="<%= fDao.friend(keyWord, "userProfile") %>" alt="" class="my-profile-img">
            <div>
                <div>
                    <div><%= fDao.friend(keyWord, "userName") %></div>
                </div>
                <div>
                    <div>게시물 14</div>
                    <div>팔로워 14</div>
                    <div>팔로우 13</div>
                </div>
                <div>
                    <%= fDao.friend(keyWord, "introduce") %>
                </div>
            </div>
        </div>
        <div id="my-infos">
            <div>게시물</div>
            <div>
            <%
            	myBoard myB = new myBoard();
 				String[] boardArr = myB.myBoardRetrun(dao.getMyData(fDao.friend(keyWord, "idx"), "idx"));
 				String idx = dao.getMyData(fDao.friend(keyWord, "idx"), "idx");
 				for(int i=0; i<=100; i++) {
 					if(boardArr[i] == null) {
 	 					break;
 					}
 					%>
					
					<!-- get image -->
					<div class="board-img">
                    	<img src="<%= myB.myboard(boardArr[i], "image") %>" class="my-board-img" alt="">
                    	<div>
	                        <div><%= myB.myboard(boardArr[i], "userContent") %></div>
                    	</div>
                	</div>
 					<%
 				}
            %>

            </div>
        </div>
    </section>
</body>

</html>