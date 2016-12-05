<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경 화면</title>
<script src="./js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="./css/material.min.css">
<script src="./js/material.min.js"></script>
<script src="./js/bnj.changePasswd.js"></script>
</head>
<body>
        <br><br>
        <p style="text-align:center; margin-top:40px"><b><font size="6" color="gray">회원 수정</font></b></p>
        <br>
	비밀번호 변경 : <input id="passwd" type="text" maxlength="50">
	<input type="button" id="changePasswd" name="changePasswd" value="수정하기">
	<a href="userMain.do"><input type="button" value="돌아가기"></a>
</body>
</html>