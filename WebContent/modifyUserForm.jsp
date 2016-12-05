<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>회원 수정 화면</title>
    
    <!-- css 파일 분리 -->
    <link rel="stylesheet" href="./css/material.min.css">
	<script src="./js/material.min.js"></script>
	<link rel="stylesheet" href="./css/bnj.login.css">
		<link rel="stylesheet" href="./css/bnj.layout.css">
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="./js/ah.js"></script>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	
</head>
<body>
    <!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
        <br><br>
        <p style="text-align:center; margin-top:40px"><b><font size="6" color="gray">회원 수정 화면</font></b></p>
        <br>
		<c:forEach var="user" items="${userList}"> 
   
        <!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 insertUserPro.do -->
          <div id="wrap">
            <table style="width:100%">
                <tr>
                    <td style="text-align:center" id="title">이름</td>
                    <td>
                        <input id="name" name="name" type="text" maxlength="50" value="${user.getUserName()}">
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title">생일</td>
                    <td>
                        <input type="text" id ="birthyy" name="birthyy" maxlength="4" placeholder="년(4자)" size="6" value="${user.getBirthyy()}" style="width:43%;">
                        <select id="birthmm" name="birthmm" style="width:11%" value="${user.getBirthmm()}">
                            <option value="">월</option>
                            <option value="01" >1</option>
                            <option value="02" >2</option>
                            <option value="03" >3</option>
                            <option value="04" >4</option>
                            <option value="05" >5</option>
                            <option value="06" >6</option>
                            <option value="07" >7</option>
                            <option value="08" >8</option>
                            <option value="09" >9</option>
                            <option value="10" >10</option>
                            <option value="11" >11</option>
                            <option value="12" >12</option>
                        </select>
                        <input type="text" id="birthdd" name="birthdd" maxlength="2" placeholder="일" size="4" value="${user.getBirthdd()}" style="width:43%">
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title">이메일</td>
                    <td>
                        <input type="text" id="mail1" name="mail1" maxlength="50" value="${user.getMail1()}" style="width:70%">@
                        <select id="mail2" name="mail2" value="${user.getMail2()}">
                            <option>naver.com</option>
                            <option>daum.net</option>
                            <option>gmail.com</option>
                            <option>nate.com</option>                        
                        </select>
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title">휴대전화</td>
                    <td>
                        <input type="text" id="phone" name="phone" value="${user.getUserCellNo()}"/>
                    </td>
                </tr>
            </table>
   		</c:forEach>  
            <br>
            <input id="process" class="mdl-button mdl-js-button mdl-js-ripple-effect" style="margin-left: 40%" type="button" value="수정"/>
            <a href="userList.do"><input class="mdl-button mdl-js-button mdl-js-ripple-effect" type="button"  value="취소"></a>
		</div>
</body>
</html>