/**
 * 게시물 상세화면 js
 */
var boardDetailModule = $(this).ready(function(){
	
	console.log(dto);
	$('#txtpwd').hide();
	$('#inptpwd').hide();
	$('#btnModConfirm').hide();
	$('#btnDelConfirm').hide();
	$('#btnModUpdate').hide();
	
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
	
	//수정하기 클릭
	$('#btnModify').on('click',function(){
		$('#txtpwd').show();
		$('#inptpwd').show();
		$('#btnModConfirm').show();
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
	
	//수정 비밀번호 확인
	$('#btnModConfirm').on('click',function(){
		var params = {};
		params.id = $('#id').val();
		params.pwd = $('#inptpwd').val();
		
		$.ajax({
			url : '/board/chkpwd',
			async : true,
			type : 'GET',
			data : params,
			success : function(res){
				console.log(res);
				if(res == 'pwdError'){
					alert('비밀번호가 맞지 않습니다');
					return;
				}
				
				$("#title").attr("disabled", false);
				$("#contents").attr("disabled", false);
				
				$('#txtpwd').hide();
				$('#inptpwd').hide();
				$('#btnModConfirm').hide();
				$("#btnDelete").hide();
				$("#btnModify").hide();
				
				$('#btnModUpdate').show();
			},
			error : function() {
				console.log('error..');
			}
		});
	});
	
	
	$('#btnModUpdate').on('click',function(){
		var params = {};
		params.id = $('#id').val();
		params.title = $('#title').val();
		params.contents = $('#contents').val();
		
		$.ajax({
			url : '/board/update',
			async : true,
			type : 'POST',
			data : params,
			success : function(res){
				console.log(res);
			
				$("#title").attr("disabled", true);
				$("#contents").attr("disabled", true);
				
				$('#btnModUpdate').hide();
				
				$("#btnDelete").show();
				$("#btnModify").show();
				
			},
			error : function() {
				console.log('error..');
			}
		});
	});
	
});