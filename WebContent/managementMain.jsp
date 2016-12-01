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
<title>Presteej Management 메인 화면</title>
</head>
<body>

	<div class="w3-container w3-padding-32" id="Today HotItem">
		<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">Today
			HotItem</h3>
	</div>
	<div class="w3-row-padding">
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<div class="w3-display-topleft w3-black w3-padding">Today HoT1</div>
				<img src=" " alt="Fren" style="width: 100%">
			</div>
		</div>
	<form action="addItem.do" method="post">
  <div class="w3-row-padding">
  <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
 	경매 등록하기
</button>
</form>	
		
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<div class="w3-display-topleft w3-black w3-padding">Today HOT2</div>
				<img src="" alt="idea" style="width: 100%">
			</div>
		</div>
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<div class="w3-display-topleft w3-black w3-padding">Today HOT3</div>
				<img src="" alt="idea" style="width: 100%">
			</div>
		</div>


		
</body>
</html>