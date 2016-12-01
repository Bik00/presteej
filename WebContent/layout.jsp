<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>presteej 레이아웃 페이지</title>
<link rel="stylesheet" href="./css/bnj.layout.css">
<link rel="stylesheet" href="./css/w3.css">
<link rel="stylesheet" href="./css/material.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="container">
<header class="w3-top"><nav>
				<ul class="w3-navbar w1-white w3-wide w3-padding-4 w3-card-2">
					<li><c:choose>
							<c:when test="${sessionScope.check2==null }">
								<a href="index.do" class="w3-margin-left">Presteej</a>
							</c:when>
							<c:when test="${sessionScope.check2=='0'}">
								<a href="userMain.do" class="w3-margin-left">PresteeJ<b>User</b></a></li>
					<li><a href="userLogin.do?command=logout">Logout</a></li>
					<li class="w3-right w3-hide-small"><a href="#Today Start"
						class="w3-left">Today Start</a> <a href="#ING" class="w3-left">ING</a>
						<a href="#Q&A" class="w3-left w3-margin-right">Q&A</a></li>
					</c:when>
					<c:when test="${sessionScope.check2=='1'}">
						<li><a href="adminMain.do" class="w3-margin-left">PresteeJ<b>Management</b></a></li>
						<li><a href="userLogin.do?command=logout">Logout</a></li>
						<li class="w3-right w3-hide-small"><a href="#Today Hot"
							class="w3-left">Today Hot</a> <a href="#Border" class="w3-left">게시판</a>
							<a href="#???" class="w3-left w3-margin-right">???</a></li>
					</c:when>
					</c:choose>
				</ul>
			</nav></header>
<section>
  <c:if test="${cont!=null}">
    <jsp:include page="${cont}"></jsp:include>
  </c:if>
</section>
<footer>
  <p> 프로젝트 이름 : Presteej 조 이름 : BnJ 만든 이 : 구본일, 양정석</p>
</footer>
</div>
</body>
</html>