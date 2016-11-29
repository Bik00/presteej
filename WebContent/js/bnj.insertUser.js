var status = true;

$(document).ready(function(){
	//[ID중복확인] 버튼을 클릭하면 자동실행
	//입력한 아이디 값을 갖고 confirmID.jsp 페이지 실행
	$("#checkId").click(function(){
		if($("#id").val()){
			//아이디를 입력하고[ID중복확인] 버튼을 클릭한 경우
			var query = {id:$("#id").val()};

			$.ajax({
				type : "post", //요청방식
				url : "userConfirmId.do", //요청페이지
				data : query, //피라미터
				success : function(data){ //요청 페이지 처리에 서공 시
					   var check = $(data).find('#ck').text();
					if(check=="1") {
						alert("사용할 수 있는 아이디");
					} else
						alert("사용할 수 없는 아이디");
					}
			});
		}else{ //아이디를 입력하지 않고[ID중복확인] 버튼을 클릭한 경우
			alert("사용할 아이디를 입력");
			$("#id").focus();
		}
	});
	/*$("#shId").click(function(){
		$.ajax({
			type:"post",
			url : "shId.jsp",
			success : function(data){
				$("#aaa").html("가입된 아이디 "+ data + "");
			}
		});
	});*/
	//가입하기 버튼을 클릭하면 자동 시행
	//사용자가 가입 폼인 registerForm.jsp 페이지에 입력한 내용을 잦고
	//registerPro.jsp
	$("#process").click(function(){
		
	      if ($("#id").val()) {
	         // 아이디를 입력하고 [ID 중복확인] 버튼을 클릭한 경우
	         var query = {
	            id : $("#id").val()
	         };
	         $.ajax({
	            type : "post", // 요청방식
	            url : "userConfirmId.do", // 요청페이지
	            data : query, // 파라미터
				success : function(data){ //요청 페이지 처리에 서공 시
					   var check = $(data).find('#ck').text();
					if(check=="1") {
	                  checkIt();
		          		if(status==="true"){
		        			var query = {
		        				id : $("#id").val(),
		        				password : $("#password").val(),
		        				name : $("#name").val(),
		        				birthyy : $("#birthyy").val(),
		        				birthmm : $("#birthmm").val(),
		        				birthdd : $("#birthdd").val(),
		        				mail1 :  $("#mail1").val(),
		        				mail2 :  $("#mail2").val(),
		        				phone : $("#phone").val()};
	
		        			$.ajax({
		        				type : "post",
		        				url : "registerUserPro.do",
		        				data : query,
		        				success : function(data){
		        					alert("성공");
		        					window.location.href="main.jsp";
		        				}
		        			});
		        		}
	               } else{// 사용할 수 없는 아이디
	                  alert("아이디 중복");
	               }
	            }
	         });
	      }
	});
});

//사용자가 입력폼에 입력한 상황을 체크
function checkIt(){
	status = true;

	if(!$("#id").val()){ //아이디를 입력하지 않으면 수행
		alert("아이디를 입력하세요");
		$("#id").focus();
		status = false;
		return false; //사용자가 서비스를 요청한 시점으로 돌아감
	}
	if(!$("#password").val()){ //비밀번호를 입력하지 않으면 수행
		alert("비밀번호를 입력하세요");
		$("#password").focus();
		status = false;
		return false;
	}
	//비밀번호와 재입력 비밀번호가 같지 않으면 수행
	if($("#password").val() != $("#repass").val()){
		alert("비밀번호를 동일하게 입력하세요");
		$("#repass").focus();
		status = false;
		return false; //사용자가 서비스를 요청한 시점으로 돌아감
	}
	if(!$("#name").val()){ //이름를 입력하지 않으면 수행
		alert("사용자 이름을 입력하세요");
		$("#name").focus();
		status = false;
		return false;
	}
	if(!$("#birthyy").val()){ //주소를 입력하지 않으면 수행
		alert("생년월일(년도)를 입력하세요");
		$("#birthyy").focus();
		status = false;
		return false;
	}
	if(!$("#birthmm").val()){ //주소를 입력하지 않으면 수행
		alert("생년월일(월)을 선택하세요");
		$("#birthmm").focus();
		status = false;
		return false;
	}
	if(!$("#birthdd").val()){ //주소를 입력하지 않으면 수행
		alert("생년월일(일)을 입력하세요");
		$("#birthdd").focus();
		status = false;
		return false;
	}
	if(!$("#mail1").val()){ //주소를 입력하지 않으면 수행
		alert("이메일을 입력하세요");
		$("#mail1").focus();
		status = false;
		return false;
	}
	if(!$("#mail2").val()){ //주소를 입력하지 않으면 수행
		alert("이메일 주소를 선택하세요");
		$("#mail2").focus();
		status = false;
		return false;
	}
	if(!$("#phone").val()){ //전화번호를 입력하지 않으면 수행
		alert("휴대폰 번호를 입력하세요");
		$("#phone").focus();
		status = false;
		return false;
	}
}
