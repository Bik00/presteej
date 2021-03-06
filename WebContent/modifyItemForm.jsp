<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>아이템 수정 화면</title>
    
    <!-- css 파일 분리 -->
    <link rel="stylesheet" href="./css/material.min.css">
	<script src="./js/material.min.js"></script>
	<link rel="stylesheet" href="./css/bnj.login.css">
	<link rel="stylesheet" href="./css/bnj.layout.css">
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="./js/ah.js"></script>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	
</head>
<script>
function showDiv( id ) {
	document.all.franBox.style.visibility = 'hidden'; 
	document.all.ideaBox.style.visibility = 'hidden'; 
	document.all[ id ].style.visibility = 'visible'; 
	document.all[ id ].focus();
}
</script>
<body>
    <!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
        <br><br>
        <p style="text-align:center; margin-top:40px"><b><font size="6" color="gray">아이템 수정</font></b></p>
        <br>
   		<c:forEach var="item" items="${itemList}">        		

        
        <!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
        <!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 insertUserPro.do -->
        <div id="wrap">
            <table style="width:100%">
                <tr>
                    <td id="title" style="text-align:center; width:120px;">아이템 이름</td>
                    <td>
                        <input id="name" name="name" type="text" maxlength="50" value="${item.getItemName()}" autofocus>
                    </td>
                </tr>      
                <tr>
                    <td style="text-align:center" id="title">아이템 가격</td>
                    <td>
                        <input id="price" name="price" type="text" maxlength="50" value="${item.getItemPrice()}">
                    </td>
                </tr>
       
                <tr>
                    <td style="text-align:center" id="title">경매 시작 날짜</td>
                    <td>
                        <input id="startdate" name="startdate" type="date" value="${item.getItemStartDate()}">
                    </td>
                </tr>
                
                 <tr>
                    <td style="text-align:center" id="title">경매 종료 날짜</td>
                    <td>
                        <input id="enddate" name="enddate" type="date" value="${item.getItemEndDate()}">
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title">아이템 상세 정보</td>
                    <td>
                        <textarea id="detail" name="detail" rows="10"cols="50">${item.getItemDetail()}</textarea>
                    </td>
                </tr>
            </table>
            <div id="id" style="display:none"><h1>${item.getItemId()}</h1></div>
            <br>
			</c:forEach>
       		
            <input id="process" class="mdl-button mdl-js-button mdl-js-ripple-effect" style="margin-left: 40%" type="button" value="수정"/>
            <a href="adminMain.do"><input class="mdl-button mdl-js-button mdl-js-ripple-effect" type="button"  value="취소"></a>
		</div>
</body>
</html>