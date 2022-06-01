package com.mycom.myapp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.board.dto.BoardDTO;
import com.mycom.myapp.board.repository.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	public List<BoardDTO> getBoardList(){
		return boardMapper.getBoardList();
	}
}
