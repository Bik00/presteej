<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>낙찰가 조회 화면</title>
    
    <!-- css 파일 분리 -->
    <link rel="stylesheet" href="./css/material.min.css">
	<script src="./js/material.min.js"></script>
	<link rel="stylesheet" href="./css/bnj.login.css">
		<link rel="stylesheet" href="./css/bnj.layout.css">
	<script src="./js/jquery-3.1.1.min.js"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<div id="listHeader">
		<p>등록된 입찰 내역(전체 내역:${count})</p>
	</div>
	<div id="bids">
		<c:if test="${count == 0}">
			<ul>
				<li>등록된 내역이 없습니다.
			</ul>
		</c:if>
		<c:if test="${count > 0}">
			<table>
				<tr class="title">
					<td align="center" width="100">아이템 이름</td>
					<td align="center" width="100">낙찰자 이름</td>
					<td align="center" width="100">낙찰가</td>
				</tr>
				<c:set var="number" value="${0}" />
				<c:forEach var="cart" items="${cartList}">

					<tr>
						<td width="100">${cart.getItemName()}</td>
						<td width="100">${cart.getUserName()}</td>
						<td width="100" align="left">${cart.getResultPrice()}</td>
					</tr>

				</c:forEach>
			</table>
		</c:if>

	</div>
</body>
</html>