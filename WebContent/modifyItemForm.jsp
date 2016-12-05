<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>아이템 수정 화면</title>
    
    <!-- css 파일 분리 -->
    <link rel="stylesheet" href="./css/material.min.css">
	<script src="./js/material.min.js"></script>
	<link rel="stylesheet" href="./css/bnj.login.css">
		<link rel="stylesheet" href="./css/bnj.layout.css">
	<script src="./js/jquery-3.1.1.min.js"></script>
 	
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
        
        
        <!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
        <!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 insertUserPro.do -->
          <form action="addItemPro.do" method="post" enctype="multipart/form-data">
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
                        <input id="imgurl" name="imgurl" type="file" maxlength="50">
                    </td>
                </tr>
                    
                <tr>
                    <td style="text-align:center" id="title" rowspan="2">사업자 / 특허 번호</td>
                    <td>
						프랜차이즈 등록: <input type=radio name=radioBtn onClick="showDiv( 'franBox' );"> 
						<span id="franBox" style="visibility:hidden">
						<input type="text"  name="franBox01" maxlength="3" style="width:20%" placeholder="세무서의 기관 코드">-
						<input type="text"  name="franBox02" maxlength="2" style="width:20%" placeholder="사업자 구분 코드">-
						<input type="text"  name="franBox03" maxlength="5" style="width:20%" placeholder="일련 번호"></span>
                    </td>
                </tr>
                <tr>
                	<td>
                		창업 아이템 등록: <input type=radio name=radioBtn onClick="showDiv( 'ideaBox' );"> 
						<span id="ideaBox" style="visibility:hidden">
						<input type="text"  name="ideaBox01" maxlength="2" style="width:20%" placeholder="특허 종류">-
						<input type="text"  name="ideaBox02" maxlength="4" style="width:20%" placeholder="출원 년도">-
						<input type="text"  name="ideaBox03" maxlength="6" style="width:21%" placeholder="일련번호"></span>
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
                        <textarea id="detail" name="detail" rows="10"cols="50"></textarea>
                    </td>
                </tr>
                   
            </table>
            <br>
            <input class="mdl-button mdl-js-button mdl-js-ripple-effect" style="margin-left: 40%" type="submit" value="등록"/>
            <a href="adminMain.do"><input class="mdl-button mdl-js-button mdl-js-ripple-effect" type="button"  value="취소"></a>
		</form>
</body>
</html>