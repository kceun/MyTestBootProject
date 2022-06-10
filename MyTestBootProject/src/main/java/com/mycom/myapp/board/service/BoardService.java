package com.mycom.myapp.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.board.dto.BoardDTO;
import com.mycom.myapp.board.repository.BoardMapper;
import com.mycom.myapp.board.repository.BoardRepository;
import com.mycom.myapp.cmn.service.CmnService;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CmnService cmnService;
	
	public List<BoardDTO> getBoardList(){
		return boardMapper.getBoardList();
	}
	
	public BoardDTO getBoardById(Integer id) {
		BoardDTO dto = null;
		Optional<BoardDTO> op = boardRepository.findById(id);
		if(op.isPresent())
			dto = op.get();
		return dto;
	}
	
	public void insertBoard(BoardDTO dto) {
		//비밀번호 암호화하기
		String salt = cmnService.getSalt();
		String result = cmnService.getEncrypt(dto.getPwd(), salt);
		dto.setPwd(result);
		dto.setSalt(salt);
		
		boardMapper.insertBoard(dto);
	};
	
}
