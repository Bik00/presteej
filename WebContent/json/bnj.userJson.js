
$(window).on('load', function() {
	$.ajax({
		type : "POST", //요청방식
		url : "bidListPro.do", //요청페이지
		success : function(data){ //요청 페이지 처리에 서공 시
			//성공 처리 함수
			var result = $(data).find('#data').text();
            var list = $.parseJSON(result);
            var item = list.item;
            var contentStr = "";
            for(var i=0; i<item.length;i++){
            	var row = item[i];
                contentStr += "<div class='card slideUp mdl-button' id='item'>" +
				"<img src='./upload/"+row.itemImgUrl+"' alt='Avatar' id='image'>" +
				"<div class='container'>" +
				"<h4><b>"+row.itemName+"</b></h4>" +
				"<p>사업자 번호 : "+row.itemRegNo.substring(0,12)+"</p>" +
				"<p>가격 : "+row.itemPrice+" 만원</p>" +
				"<p> 경매 시작일 : "+row.itemStartDate+"</p>" +
				"<p> 경매 종료일 : "+row.itemEndDate+"</p>" +
				"<p style='visibility:hidden' id='itemId'>"+row.itemId+"</p>" +
				"<input type='text' id='bidText' class='okay' name='bidText' maxlength='50'>"+
				"<button id='bid' name="+row.itemId+">입찰하기</button>"+
				"</div>" +
				"</div>";
            }
			$("#callJson").append(contentStr);
		}
	});
});


$(document).on('click', '#bid', function(){ 
	var check = $('input:text').filter(function() { return $(this).val() != ""; });
	var check2 = check.prev();
	var query = {name:$("#name").text(),
		itemId:check2.text(),
		bidText:check.val()	
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