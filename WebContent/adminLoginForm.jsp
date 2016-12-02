<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인</title>
<script src="./js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="./css/material.min.css">
<script src="./js/material.min.js"></script>
<script src="./js/bnj.adminLogin.js"></script>
<link rel="stylesheet" href="./css/bnj.login.css">

<script>
$(document).ready(function () {
	$("#password").keydown(function (e) {
		  if (e.keyCode == 13) {
				var query = {
						id:$("#id").val(),
						password:$("#password").val()
						};
				
				$.ajax({
					type:"POST",
					url:"adminLogin.do",
					data:query,
					success:function(data) {
						   var check = $(data).find('#ck').text();
						   if(check=="1") {
							   alert("로그인에 성공하셨습니다!");
								window.location.href="adminMain.do";
						   } else if(check=="0") {
							   $("#id").val("");
							   alert("비밀번호가 틀렸습니다.");
							   $("#password").val("");
						   } else {
							   alert("아이디가 틀렸습니다.");
							   $("#id").val("");
							   $("#password").val("");
						   }
					}
				});
		  }
		});
});

</script>

</head>

<body>
	${error}
	<form method="post">
		<div class="imgcontainer">
			<img src="./image/selectAdmin.png" class="avatar">
		</div>
		<div class="container">
			<label><b>관리자 아이디</b></label> <input type="text"
				placehold	er="Enter Username" name="id" id="id" required> <label><b>관리자
					비밀번호</b></label> <input type="password" placeholder="Enter Password" id="password" name="password"
				required>
			<button type="button" id="loginAdminButton" name="enter">로그인</button>
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<a href="index.do"><button type="button" class="cancelbtn">취소</button></a>
		</div>
	
	</form>
</body>
</html>