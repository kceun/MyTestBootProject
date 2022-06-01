package com.mycom.myapp.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.board.dto.BoardDTO;
import com.mycom.myapp.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	// VIEW ========================================================================
	@GetMapping("/board")
	public ModelAndView boardList() {
		ModelAndView model = new ModelAndView();
		model.addObject("boardList", boardService.getBoardList());
		model.setViewName("board/board-list");
		
		return model;
	}
	
	
	// API ========================================================================
//	@GetMapping("/board/list")
//	public List<BoardDTO> getBoardList(){
//		return boardService.getBoardList();
//	}
}
