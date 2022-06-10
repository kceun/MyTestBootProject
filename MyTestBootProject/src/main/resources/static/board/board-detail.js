/**
 * 게시물 상세화면 js
 */
var boardDetailModule = $(this).ready(function(){
	
	console.log(dto);
	
	//목록보기 클릭
	$('#btnList').on('click',function(){
		
		location.href ='/board';
		
	});
	
});