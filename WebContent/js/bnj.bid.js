$(window).ready(function() {
	$("#bid").click(function() {
		var query = {name:$("#name").text(),
					itemId:$("#itemId").html(),
					userName:$("#userName").html(),
					bidText:$("#bidText").val()		
						};
		alert($("#name").text());
		$.ajax({
			type:"POST",
			url:"bid.do",
			data:query,
			success:function(data) {
				   var check = $(data).find('#ck').text();
				   alert("입찰에 성공하셨습니다! 낙찰 여부는 경매가 끝난 후 확인할 수 있습니다.");
				   window.location.href="userMain.do";
			}
		});
	});
});