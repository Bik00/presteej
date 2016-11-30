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
<title>Presteej User 메인 화면</title>
</head>
<body>

	<div class="w3-container w3-padding-32" id="Today Start">
		<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">Today
			Start</h3>
	</div>
	<div class="w3-row-padding">
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<div class="w3-display-topleft w3-black w3-padding">경매물품1</div>
				<img src=" " alt="Fren" style="width: 100%">
			</div>
		</div>
	<form action="addItem.do" method="post">
  <div class="w3-row-padding">
  <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
 	상품 등록하기
</button>
</form>	
		
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<div class="w3-display-topleft w3-black w3-padding">경매물품2</div>
				<img src="" alt="idea" style="width: 100%">
			</div>
		</div>
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-display-container">
				<div class="w3-display-topleft w3-black w3-padding">경매물품3</div>
				<img src="" alt="idea" style="width: 100%">
			</div>
		</div>

		<div class="w3-container w3-padding-32" id="ING">
			<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">경매진행중</h3>
			<p>-오늘의 경매 시작은-</p>
		</div>
		<div class="w3-container w3-padding-32" id="Q&A">
			<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">Q&A</h3>
			<p>답장을 받으실 이메일을 써서 질문해주세요!</p>
			<form action="form.asp" target="_blank">
				<input class="w3-input" type="text" placeholder="Name" required
					name="Name"> <input class="w3-input w3-section" type="text"
					placeholder="Email" required name="Email"> <input
					class="w3-input w3-section" type="text" placeholder="Subject"
					required name="Subject"> <input class="w3-input w3-section"
					type="text" placeholder="Comment" required name="Comment">
				<button class="w3-btn w3-section" type="submit">
					<i class="fa fa-paper-plane"></i> 질문전송.
				</button>
			</form>
		</div>
</body>
</html>