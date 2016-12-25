<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/w3.css">
<script src="./js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="./css/material.min.css">
<script src="./js/material.min.js"></script>
<script src="./js/bnj.clock.js"></script>
<script src="./json/bnj.userJson.js?ver=9"></script>
<link rel="stylesheet" href="./css/bnj.json.css">
<title>Presteej User 메인 화면</title>
</head>
<body onLoad="goforit()">

	<div class="w3-container w3-padding-32" id="Today Start">
		<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">Today
			Start</h3>
	</div>
	
			<div id="clock" style="text-align:center"><h2>로딩중...</h2></div>

		<div class="w3-container w3-padding-32" id="ING">
			<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">현재 진행중인 경매 물품 목록</h3>
<!-- 			<a href="bidList.do"><input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="button" value="보러가기"></a> -->
			<div id = "callJson"></div>
				<div id="name" style="visibility:hidden">${name}</div>
		</div>
		<div class="w3-container w3-padding-32" id="Q&A">
			<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">낙찰 이력</h3>
 			<a href="cartList.do"><input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="button" value="보러가기"></a>
		</div>
		<br>
		<br>
		<br>
</body>
</html>