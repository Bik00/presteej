<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/w3.css">
<script src="./js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="./css/material.min.css">
<script src="./js/material.min.js"></script>
<script src="./js/bnj.bid.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>현재 진행중인 경매물품 화면</title>
</head>
<body>
	<div id="listHeader">
		<p>등록된 아이템 목록(전체 사용자:${count})</p>
	</div>
	<div id="users">
		<c:if test="${count == 0}">
			<ul>
				<li>등록된 경매 물품이 없습니다.
			</ul>
		</c:if>
		<c:if test="${count > 0}">
			<table>
				<tr class="title">
					<td align="center" width="200">그림</td>
					<td align="center" width="30">번호</td>
					<td align="center" width="200">아이템 이름</td>
					<td align="center" width="70">가격</td>
					<td align="center" width="70">내가 입찰한 가격</td>
					<td align="center" width="200">사업자 번호 / 특허 번호</td>
					<td align="center" width="70">경매 시작 날짜</td>
					<td align="center" width="70">경매 종료 날짜</td>
					<td align="center" width="30">재고</td>
					<td align="center" width="50">경매 가격</td>
					<td align="center" width="50">입찰</td>
				</tr>

				<c:set var="number" value="${0}" />
				<c:forEach var="item" items="${bidList}">
					<tr>
						<td align="center" width="200"><img width="200" height="200" src="upload/${item.getItemImgUrl()}"></td>
						<td width="30" id="itemId">${item.getItemId()}</td>
						<td width="200">${item.getItemName()}</td>
						<td width="70" align="left">${item.getItemPrice()}</td>
						<td width="70" align="left">${item.getItemPrice()}</td>
						<td width="200" align="right">${item.getItemRegNo()}</td>
						<td width="70">${item.getItemStartDate()}</td>
						<td width="70">${item.getItemEndDate()}</td>
						<td width="30">${item.getRemain()}</td>
						<td width="50">
							<input type="text" id="bidText" name="bidText" maxlength="50">
						<td width="50">
							<button id="bid"
								name="${item.getItemId()}" onclick="bid(this)">입찰하기</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<div id="name" style="visibility:hidden">${name}</div>
</body>
</html>