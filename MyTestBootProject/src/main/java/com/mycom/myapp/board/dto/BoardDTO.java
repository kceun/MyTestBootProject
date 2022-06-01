package com.mycom.myapp.board.dto;

import com.mycom.myapp.cmn.dto.BaseDTO;

import lombok.Data;

@Data
public class BoardDTO extends BaseDTO {
	
	/* 게시글 id */
	private int id;
	

	/* 제목 */
	private String title;
	
	/* 내용 */
	private String contents;
	
	/* 게시글 상태 */
	private String docsttcd;

	/* 조회수 */
	private int cnt;

	/* 비밀번호 */
	private String pwd;
	
	/* 공감수 */
	private int love;

}
