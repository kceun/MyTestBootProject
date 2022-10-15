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
		//조회수 ++
		boardMapper.updateBoardCnt(id);
		
		//가져오기
		BoardDTO dto = boardRepository.findById(id).orElse(null);
		return dto;
	}
	
	public void insertBoard(BoardDTO dto) {
		//비밀번호 암호화하기
		String salt = cmnService.getSalt();
		String result = cmnService.getEncrypt(dto.getPwd(), salt);
		dto.setPwd(result);
		dto.setSalt(salt);
		
		boardMapper.insertBoard(dto);
	}
	
	public String deleteBoard(BoardDTO dto) {
		
		// 비밀번호 맞는지 체크
		String res = this.checkPwd(dto.getId(), dto.getPwd());
		
		if(res.equals("pwdError"))
			return res;
		
		boardMapper.deleteBoard(dto.getId());
		
		return res;
	}
	
	//====================================================================
	
	public String checkPwd(Integer id, String pwd) {
		
		BoardDTO dto = boardRepository.findById(id).orElse(null);
		String salt = dto.getSalt();
		String inputPwd = cmnService.getEncrypt(pwd, salt);
		
		if(inputPwd.equals(dto.getPwd())) {
			return "Success";
		} else {
			return "pwdError";
		}
		
	}
	
	
}
