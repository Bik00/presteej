<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>presteej 레이아웃 페이지</title>
<link rel="stylesheet" href="./css/bnj.layout.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="container">
<header><nav>
  <ul>
    <li><a href="index.do">New</a></li>
    <c:if test="${sessionScope.id != null }">
    <li><a href="userLogin.do?command=logout">Logout</a></li>
    </c:if>
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