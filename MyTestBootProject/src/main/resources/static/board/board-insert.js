/**
 * 게시물 작성 js
 */
$(this).ready(function(){ //$('document').ready(function(){
	
	$('#btnSave').on('click',function(){
	
		var url = '/board/insert';
		var params = {};
		
		params.regid = $('#name').val();
		params.contents = $('#contents').val();
		params.pwd = $('#pwd').val();
		params.title =$('#title').val();
		
		//div를 가져와서 쪼개는 방법은 없을까?
		
		$.ajax({
			url : url,
			async : true,
			type : 'POST',
			data : params,
			dataType: 'json',
			success : function(res){
				if(res == null)
					return;
				
				location.replace('./');
				
			}
		});
		
	});
	
	
});