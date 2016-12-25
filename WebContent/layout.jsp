<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>presteej 레이아웃 페이지</title>
<link rel="stylesheet" href="./css/bnj.layout.css?ver=1">
<link rel="stylesheet" href="./css/w3.css">
<link rel="stylesheet" href="./css/material.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="container">
<header class="w3-top" style="z-index:2;"><nav>
				<ul class="w3-navbar w1-white w3-wide w3-padding-4 w3-card-2">
					<li><c:choose>
							<c:when test="${sessionScope.check2==null }">
								<a href="index.do" class="w3-margin-left">Presteej</a>
							</c:when>
							<c:when test="${sessionScope.check2=='0'}">
								<a href="userMain.do" class="w3-margin-left">PresteeJ<b>User</b></a></li>
					<li><a href="userLogin.do?command=logout">Logout</a></li>
					<li><a href="changePasswd.do">Change Info</a></li>
					<li class="w3-right w3-hide-small"><a href="#Today Start"
						class="w3-left">Today Start</a> <a href="#ING" class="w3-left">ING</a>
						<a href="#Q&A" class="w3-left w3-margin-right">Q&A</a></li>
					</c:when>
					<c:when test="${sessionScope.check2=='1'}">
						<li><a href="adminMain.do" class="w3-margin-left">PresteeJ<b>Management</b></a></li>
						<li><a href="userLogin.do?command=logout">Logout</a></li>
						<li class="w3-right w3-hide-small">
							<a href="#addItems" class="w3-left">Add Items</a>
							<a href="#schedule" class="w3-left">Schedules</a>
							<a href="#graphs" class="w3-left">Graphs</a>
							<a href="#user" class="w3-left w3-margin-right">Users</a></li>
					</c:when>
					</c:choose>
				</ul>
			</nav></header>
<section>
  <c:if test="${cont!=null}">
    <jsp:include page="${cont}"></jsp:include>
  </c:if>
</section>
<footer style="z-index:2;">
  <p id="footer"> 프로젝트 이름 : Presteej 조 이름 : BnJ 만든 이 : 구본일, 양정석</p>
</footer>
</div>
</body>
</html>