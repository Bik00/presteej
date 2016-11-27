<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="./css/material.min.css">
<script src="./js/material.min.js"></script>
<link rel="stylesheet" href="./css/bnj.loginForm.css">
</head>
<body>
	${error }
	<p id="selectAdmin">관리자 로그인</p>

	<form action="adminLogin.do" method="post">
		<div class="imgcontainer">
			<img src="./image/selectAdmin.png" class="avatar">
		</div>
		<div class="container">
			<label><b>관리자 아이디</b></label> <input type="text"
				placeholder="Enter Username" name="id" required> <label><b>관리자
					비밀번호</b></label> <input type="password" placeholder="Enter Password" name="password"
				required>
			<button type="submit" id="loginButton">로그인</button>
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<a href="index.do"><button type="button" class="cancelbtn">취소</button></a>
		</div>
	</form>
</body>
</html>