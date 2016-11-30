<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>아이템 등록 화면</title>
    
    <!-- css 파일 분리 -->
    <link rel="stylesheet" href="./css/material.min.css">
	<script src="./js/material.min.js"></script>
	<link rel="stylesheet" href="./css/bnj.login.css">
		<link rel="stylesheet" href="./css/bnj.layout.css">
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="./js/bnj.insertUser.js"></script>
 	
</head>
<body>
    <!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
        <br><br>
        <p style="text-align:center; margin-top:40px"><b><font size="6" color="gray">아이템 등록</font></b></p>
        <br>
        
        
        <!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
        <!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 insertUserPro.do -->
          <div id="wrap">
            <table style="width:100%">
                <tr>
                    <td id="title" style="text-align:center; width:120px;">아이템 이름</td>
                    <td>
                        <input id="name" name="name" type="text" maxlength="50" autofocus>
                    </td>
                </tr>      
                <tr>
                    <td style="text-align:center" id="title">아이템 가격</td>
                    <td>
                        <input id="price" name="price" type="text" maxlength="50">
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title">이미지 경로</td>
                    <td>
                        <input id="imgurl" name="imgurl" type="type" maxlength="50">
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title">사업자 / 특허 번호</td>
                    <td>
                        <input type="text" id ="itemyy" name="itemyy" maxlength="4" placeholder="년(4자)" size="6" style="width:43%;">
                        <select id="itemmm" name="itemmm" style="width:11%">
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
                        <input type="text" id="itemdd" name="itemdd" maxlength="2" placeholder="일" size="4" style="width:43%">
                    </td>
                </tr>
                
                <tr>
                    <td style="text-align:center" id="title">경매 시작 날짜</td>
                    <td>
                        <input id="startdate" name="startdate" type="date">
                    </td>
                </tr>
                
                 <tr>
                    <td style="text-align:center" id="title">경매 종료 날짜</td>
                    <td>
                        <input id="enddate" name="enddate" type="date">
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title">아이템 상세 정보</td>
                    <td>
                        <input type="textarea" id="detail" name="detail" rows="5"cols="50">
                    </td>
                </tr>
                   
            </table>
            <br>
            <input id="process" class="mdl-button mdl-js-button mdl-js-ripple-effect" style="margin-left: 40%" type="button" value="등록"/>
            <a href="adminMain.jsp"><input class="mdl-button mdl-js-button mdl-js-ripple-effect" type="button"  value="취소"></a>
		</div>
</body>
</html>