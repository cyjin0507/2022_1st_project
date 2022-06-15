<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp" />

<%
MemberDAO dao = new MemberDAO();
HttpSession s = request.getSession();
if(s.getAttribute("logOK") == null) {
	%>
	<script>
		alert("로그인 후 이용 가능합니다.")
		window.location.href="./login.jsp";
	</script>
	<%
}
%>

<section id="userControl">
	<form action="/UploadUser" method="post" enctype="multipart/form-data">
		<div id="userImg">
			<img
				src="<%= dao.getMyData((String)s.getAttribute("logOK"), "userProfile") %>" id="img-control-img" alt="">
			<div>
				<div> <%= dao.getMyData((String)s.getAttribute("logOK"), "username") %> </div>
				<input type="file" id="img_control" name="proFile_" style="display: none;">
				<label for="img_control">프로필 사진 바꾸기</label>
			</div>
		</div>
		<div class="user-info-control">
			<div>이름</div>
			<input type="text" name="name" required value="<%=dao.getMyData((String)s.getAttribute("logOK"), "username")%>">
		</div>
		<div class="user-info-control">
			<div>별명</div>
			<input type="text" name="userNickname" required value="<%=dao.getMyData((String)s.getAttribute("logOK"), "nickname")%>">
		</div>
		<div class="user-info-control">
			<div>소개글</div>
			<textarea name="userIntroduce" id="" cols="30" rows="10" required><%=dao.getMyData((String)s.getAttribute("logOK"), "introduce")%></textarea>
		</div>
		<div class="user-info-control">
			<div>이메일</div>
			<input type="text" name="userMail" required value="<%=dao.getMyData((String)s.getAttribute("logOK"), "mail")%>">
		</div>
		<div class="user-info-control">
			<div>전화번호</div>
			<input type="text" name="userPhoneNumber" required value="<%=dao.getMyData((String)s.getAttribute("logOK"), "phoneNumber")%>">
		</div>
		<div class="user-info-control">
			<div>성별</div>
			<div class="major-control-outer">
				<div class="major-control">
					<div>
						<input type="radio" name="userGender" id="man" value="he" <%=dao.getMyData((String)s.getAttribute("logOK"), "gender") == "he" ? "checked" : ""%>> <label
							for="male">남성</label>
					</div>
					<div>
						<input type="radio" name=userGender id="female" value="she" <%=dao.getMyData((String)s.getAttribute("logOK"), "gender") == "she" ? "checked" : ""%>> <label
							for="female">여성</label>
					</div>
				</div>
			</div>
		</div>
		<div class="user-info-control">
			<div>전공</div>
			<select name="userMajor" id="">
				<option value="">선택</option>
				<option value="전자">전자제어과</option>
				<option value="통신">정보통신과</option>
				<option value="소프트">소프트웨어개발과</option>
				<option value="바이오">바이오화학과</option>
				<option value="생명">생명정보과</option>
			</select>
		</div>

		<button id="user-control-btn">제출</button>

	</form>
</section>

<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/board.js"></script>


</body>
</html>