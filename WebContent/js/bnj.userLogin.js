$(document).ready(function () {
	$("#loginButton").click(function() {
		var query = {id:$("#id").val(),
				password:$("#password").val()};
		
		$.ajax({
			type:"POST",
			url:"userLogin.do",
			data:query,
			success:function(data) {
				   var check = $(data).find('#ck').text();
				   if(check=="1") {
					   alert("로그인에 성공하셨습니다!");
						window.location.href="userMain.do";
				   } else if(check=="0") {
					   $("#id").val("");
					   alert("비밀번호가 틀렸습니다.");
					   $("#password").val("");
				   } else {
					   alert("아이디가 틀렸습니다.");
					   $("#id").val("");
					   $("#password").val("");
				   }
			}
		});
	});
	
	
	$("#loginAdminButton").click(function() {
		var query = {id:$("#id").val(),
				password:$("#password").val()};
		
		$.ajax({
			type:"POST",
			url:"adminLogin.do",
			data:query,
			success:function(data) {
				   var check = $(data).find('#ck').text();
				   if(check=="1") {
					   alert("로그인에 성공하셨습니다!");
						window.location.href="adminMain.do";
				   } else {
					   alert("아이디 혹은 비밀번호가 틀렸습니다.");
					   $("#id").val("");
					   $("#password").val("");
				   }
			}
		});
	});
});