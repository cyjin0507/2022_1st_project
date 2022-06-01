<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <input type="file" id="inputImage">

  <button id="sendButton">보내기</button>

<script>

    document.querySelector("#sendButton").addEventListener('click', ()=> {
    let selectFile = document.querySelector("#inputImage").files[0]; 
    console.log(selectFile);
    })

  </script>

<script>

    document.querySelector("#sendButton").addEventListener('click',()=>{

      let selectFile = document.querySelector("#inputImage").files[0];

      const file = URL.createObjectURL(selectFile);

      document.querySelector(".uploadImage").src = file;

    })

  </script> 
    <img src="" class="uploadImage"> 
</body>
</html>