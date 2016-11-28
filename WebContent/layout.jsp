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
    <li>
      <a href="index.do" class="w3-margin-left">PresteeJ</a>
    </li>
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