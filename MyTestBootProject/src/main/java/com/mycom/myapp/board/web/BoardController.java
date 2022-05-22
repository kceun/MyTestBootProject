package com.mycom.myapp.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board")
	public String boardList() {
		return "board/board-list";
	}
}
