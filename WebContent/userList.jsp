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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>일반 회원 리스트 화면</title>
</head>
<body>
	<div id="listHeader">
		<p>등록된 사용자 목록(전체 사용자:${count})</p>
	</div>
	<div id="users">
		<c:if test="${count == 0}">
			<ul>
				<li>등록된 회원이 없습니다.
			</ul>
		</c:if>
		<c:if test="${count > 0}">
			<table>
				<tr class="title">
					<td align="center" width="50">번호</td>
					<td align="center" width="30">아이디</td>
					<td align="center" width="30">비밀번호</td>
					<td align="center" width="100">이름</td>
					<td align="center" width="50">생일</td>
					<td align="center" width="50">휴대폰 번호</td>
					<td align="center" width="70">이메일 주소</td>
					<td align="center" width="70">등록일</td>
					<td align="center" width="50">수정</td>
					<td align="center" width="50">삭제</td>
				</tr>

				<c:set var="number" value="${0}" />
				<c:forEach var="user" items="${userList}">
					<tr>
						<td align="center" width="50"><c:set var="number"
								value="${number+1}" /> <c:out value="${number}" /></td>
						<td width="30" id="id">${user.getUserId()}</td>
						<td width="30">${user.getUserPassword()}</td>
						<td width="100" align="left">${user.getUserName()}</td>
						<td width="50" align="right">${user.getUserBirthDate()}</td>
						<td width="50" align="right">${user.getUserCellNo()}</td>
						<td width="70">${user.getUserEmail()}</td>
						<td width="70">${user.getUserCreatedDate()}</td>
						<td width="50">
							<a href="modifyUser.do?id=${user.getUserId()}"><button id="edit"
								name="${user.getUserId()}"
								>수정</button></a>
						</td>
						<td width="50">
							<a href="deleteUser.do?id=${user.getUserId()}"><button id="delete"
								name="${user.getUserId()}"
								>삭제</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>