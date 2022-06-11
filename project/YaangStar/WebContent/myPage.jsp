<%@page import="userController.myBoard"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp"/>

<%
HttpSession s = request.getSession();

MemberDAO dao = new MemberDAO();
%>


    <section id="myPage">
        <div id="my-detail-info">
            <img src="<%= dao.getMyData((String)s.getAttribute("logOK"), "userprofile") %>" alt="" class="my-profile-img">
            <div>
                <div>
                    <div><%= dao.getMyData((String)s.getAttribute("logOK"), "username") %></div>
                    <a href="./userController.jsp">프로필 편집</a>
                </div>
                <div>
                    <div>게시물 5</div>
                    <div><a href="#follower">팔로워 14</a></div>
                    <div><a href="#follow">팔로우 13</a></div>
                </div>
                <div>
                    <%= dao.getMyData((String)s.getAttribute("logOK"), "introduce") %>
                </div>
            </div>
        </div>
        <div id="my-infos">
            <div>게시물</div>
            <div>
            <%
            	myBoard myB = new myBoard();
 				String[] boardArr = myB.myBoardRetrun(dao.getMyData((String)s.getAttribute("logOK"), "idx"));
 				String idx = dao.getMyData((String)s.getAttribute("logOK"), "idx");
 				for(int i=0; i<=100; i++) {
 					if(boardArr[i] == null) {
 					
 	 					break;
 					}
 					
 					%>

 					<img src="<%= myB.myboard(boardArr[i], "image") %>" class="my-board-img" alt="">
 					<%


 					
 				}
            %>

            </div>
        </div>
    </section>
</body>

</html>