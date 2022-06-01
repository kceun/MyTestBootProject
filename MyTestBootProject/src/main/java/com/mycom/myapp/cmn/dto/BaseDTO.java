package com.mycom.myapp.cmn.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BaseDTO {

	/* 작성자 */
	private String regid;
	
	/* 작성일 */
	private Date regdt; 
	
	/* 수정자 */
	private String modid;
	
	/* 수정일 */
	private Date moddt; 
	
}
