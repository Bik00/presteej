$(document).ready(function () {
	$("#changePasswd").click(function(){
		if($("#passwd").val()){
			//아이디를 입력하고[ID중복확인] 버튼을 클릭한 경우
			var query = {passwd:$("#passwd").val()};

			$.ajax({
				type : "post", //요청방식
				url : "changePasswdPro.do", //요청페이지
				data : query, //피라미터
				success : function(data){ //요청 페이지 처리에 서공 시
					   var check = $(data).find('#ck').text();
					   alert(check);
					if(check=="1") {
						alert("수정 성공");
    					window.location.href="userMain.do";
					} else
						alert("수정 실패! 다시 시도해주새요");
					}
			});
		}else{ //아이디를 입력하지 않고[ID중복확인] 버튼을 클릭한 경우
			alert("비밀번호를 입력");
			$("#passwd").focus();
		}
	});	
});
