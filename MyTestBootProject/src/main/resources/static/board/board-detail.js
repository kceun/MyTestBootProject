/**
 * 게시물 상세화면 js
 */
var boardDetailModule = $(this).ready(function(){
	
	console.log(dto);
	$('#txtpwd').hide();
	$('#inptpwd').hide();
	$('#btnModConfirm').hide();
	$('#btnDelConfirm').hide();
	
	//목록보기 클릭
	$('#btnList').on('click',function(){
		
		location.href ='/board';
		
	});
	
	
	//삭제하기 클릭
	$('#btnDelete').on('click',function(){
		$('#txtpwd').show();
		$('#inptpwd').show();
		$('#btnDelConfirm').show();
	});
	
	//삭제 완료
	$('#btnDelConfirm').on('click',function(){
		var params = {};
		params.id = $('#id').val();
		params.pwd = $('#inptpwd').val();
		
		$.ajax({
			url : '/board/delete',
			async : true,
			type : 'POST',
			data : params,
			success : function(res){
				console.log(res);
				if(res == 'pwdError'){
					alert('비밀번호가 맞지 않습니다');
					return;
				}
				
				location.href = '/board';
				
			},
			error : function() {
				console.log('error..');
			}
		});
	});
});