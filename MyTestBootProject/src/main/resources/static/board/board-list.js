/**
 * 게시물 전제 조회 화면 js
 */

$(this).ready(function(){ //$('document').ready(function(){
	
	$('#btnWrite').on('click',function(){
		var url = '/board/insert';
//		alert('날 눌렀어!');
		$.ajax({
			url : url,
			async : true,
			type : 'GET',
			data : {},
			success : function(res){
				if(res == null)
					return;
				
				location.href=url;
				
			}
		});
		
	});
	
	
});