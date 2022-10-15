package com.mycom.myapp.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.myapp.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> getBoardList();
	
	public void insertBoard(@Param("param") BoardDTO dto);
	
	public void updateBoardCnt(Integer id);
	
	public void deleteBoard(Integer id);
	
	public void updateBoard(@Param("param") BoardDTO dto);
}
