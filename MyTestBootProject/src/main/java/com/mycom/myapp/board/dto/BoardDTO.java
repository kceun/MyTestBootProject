package com.mycom.myapp.board.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mycom.myapp.cmn.dto.BaseDTO;

import lombok.Data;


@Data
@Entity
@Table(name ="TB_BOARD")
public class BoardDTO extends BaseDTO {
	
	/* 게시글 id */
	@Id
	private Integer id;
	

	/* 제목 */
	@Column
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
	
	/* Salt */
	private String salt;

}
