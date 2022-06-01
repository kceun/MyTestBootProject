package com.mycom.myapp.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> getBoardList();
	
}
