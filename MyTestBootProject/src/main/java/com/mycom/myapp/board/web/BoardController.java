package com.mycom.myapp.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/board/insert")
	public ModelAndView boardInsert() {
		ModelAndView model = new ModelAndView();
		model.setViewName("board/board-insert");
		
		return model;
	}
	
	@GetMapping("/board/detail/{id}")
	public ModelAndView boardDetail(@PathVariable Integer id ) {
		ModelAndView model = new ModelAndView();
		model.addObject("dto",boardService.getBoardById(id));
		model.setViewName("board/board-detail");
		
		return model;
	}
	
	
	// API ========================================================================
	@PostMapping("/board/insert")
	public void getBoardList(BoardDTO dto){
		boardService.insertBoard(dto);
	}
}
