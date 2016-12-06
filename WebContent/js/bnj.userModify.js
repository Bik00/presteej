$(window).ready(function() {	
	$("#process").click(function(){
			var query = {
			id : $("#id").text(),
			name : $("#name").val(),
			birthyy : $("#birthyy").val(),
			birthmm : $("#birthmm").val(),
			birthdd : $("#birthdd").val(),
			mail1 :  $("#mail1").val(),
			mail2 :  $("#mail2").val(),
			phone : $("#phone").val()};
			$.ajax({
				type : "post",
				url : "modifyUserPro.do",
				data : query,
				success : function(data){
					alert("수정 완료");
					window.location.href="adminMain.do";
			}
	   });
	});
});