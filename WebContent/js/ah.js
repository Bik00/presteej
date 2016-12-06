$(window).ready(function() {	
	$("#process").click(function(){
			var query = {
			id : $("#id").text(),
			name : $("#name").val(),
			price : $("#price").val(),
			startdate : $("#startdate").val(),
			enddate : $("#enddate").val(),
			detail :  $("#detail").html() }
			$.ajax({
				type : "post",
				url : "modifyItemPro.do",
				data : query,
				success : function(data){
					alert("수정 완료");
					window.location.href="adminMain.do";
			}
	   });
	});
});