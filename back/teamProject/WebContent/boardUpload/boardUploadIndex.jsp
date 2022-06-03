<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="Action"
		action="/boardUpload/boardUploadProc.jsp"
		method="post" enctype="multipart/form-data">
		<div class="form-group">
			사진 : <input type="file" name="image"><br>
		</div>
		<textarea rows="5" cols="40" name="userContent"></textarea>
		<br>
		<textarea rows="3" cols="40" name="tage"></textarea>
		<br>
		<button id="btn" onclick="clickBtn()">추가</button>

		<script>
			function clickBtn() {
				$('#Action').submit();
			}
		</script>
	</form>

	<br>
	<Br>

	<a href="/login/index.jsp">돌아가기</a>
</body>
</html>