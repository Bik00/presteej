<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="w3-content w3-padding" style="max-width:1564px">

  <div class="w3-container w3-padding-32" id="addItems">
    <h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">아이템 등록하기</h3>
  </div>

<form action="addItem.do" method="post">
  <div class="w3-row-padding">
  <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
 	상품 등록하기
</button>
</form>
  
   		<div class="w3-container w3-padding-32" id="schedule">
			<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">경매 일정 현황</h3>
 			<a href="itemList.do"><input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="button" value="보러가기"></a>
			<jsp:include page="/test.jsp" flush="false"/>
		</div>
  
  		<div class="w3-container w3-padding-32" id="graphs">
			<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">입찰가 현황판</h3>
 			<a href="history.do"><input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="button" value="보러가기"></a>
		</div>
  
  
  		<div class="w3-container w3-padding-32" id="user">
			<h3 class="w3-border-bottom w3-border-light-grey w3-padding-12">사용자 관리</h3>
 			<a href="userList.do"><input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="button" value="클릭"></a>
		</div>
		<br>
		<br>
		<br>
</body>
</html>