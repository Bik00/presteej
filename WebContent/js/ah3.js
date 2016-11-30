$(document).ready(function () {
	$("#loginAdminButton").click(function() {
		var query = {id:$("#id").val(),
				password:$("#password").val()};
		
		$.ajax({
			type:"POST",
			url:"adminLogin.do",
			data:query,
			success:function(data) {
					alert(data);
				   var check = $(data).find('#ck').text();
				   alert(check);
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