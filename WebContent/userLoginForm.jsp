<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원 로그인</title>
<script src="./js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="./css/material.min.css">
<script src="./js/material.min.js"></script>
<script src="./js/bnj.userLogin.js"></script>
<link rel="stylesheet" href="./css/bnj.login.css">
</head>
<body>
	${error }
	<p id="selectUser" style="margin-top:80px">일반 회원 로그인</p>

	<form method="post">
		<div class="imgcontainer">
			<img src="./image/selectUser.png" class="avatar">
		</div>
		<div class="container">
			<label><b>유저 아이디</b></label> <input type="text"
				placeholder="Enter Username" name="id" id="id" required> <label><b>유저
					비밀번호</b></label> <input type="password" placeholder="Enter Password" id="password" name="password"
				required>
			<button type="button" id="loginButton">로그인</button>
			<a href="insertUser.do"><button type="button" id="insertButton">회원 가입</button></a>
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<a href="index.do"><button type="button" class="cancelbtn">취소</button></a>
		</div>
	</form>
</body>
</html>