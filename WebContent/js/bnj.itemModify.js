$(window).ready(function() {
	$("#delete").click(function() {
		var query = {name:$("#name").html()};
		$.ajax({
			type:"POST",
			url:"deleteItem.do",
			data:query,
			success:function(data) {
				   alert("삭제");
				   window.location.reload(true);
			}
		});
	});
});