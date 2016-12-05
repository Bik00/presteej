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
<script src="./js/bnj.userModify.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>입찰가 현황판</title>
</head>
<body>
	<div id="listHeader">
		<p>등록된 입찰 내역(전체 내역:${count})</p>
	</div>
	<div id="bids">
		<c:if test="${count == 0}">
			<ul>
				<li>등록된 회원이 없습니다.
			</ul>
		</c:if>
		<c:if test="${count > 0}">
			<table>
				<tr class="title">
					<td align="center" width="100">아이템 이름</td>
					<td align="center" width="100">입찰자 이름</td>
					<td align="center" width="100">입찰가</td>
					<td align="center" width="100">등록한 날짜</td>
				</tr>

				<c:set var="number" value="${0}" />
				<c:forEach var="bid" items="${bidList}">
					<tr>
						<td width="100">${bid.getItemName()}</td>
						<td width="100">${bid.getUserName()}</td>
						<td width="100" align="left">${bid.getBidPrice()}</td>
						<td width="100" align="right">${bid.getDb()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>