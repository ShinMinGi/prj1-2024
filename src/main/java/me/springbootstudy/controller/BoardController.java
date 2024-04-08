package me.springbootstudy.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.springbootstudy.domain.Board;
import me.springbootstudy.service.BoardService;

@Controller
@RequestMapping("/")
public class BoardController {


	@Autowired
	private BoardService service; 
	// 경로 : http://localhost:8080
	// 경로 : http://localhost:8080/list
	// 게시물 목록 
//	@RequestMapping(value = {"/", "list"}, method = RequestMethod.GET)
	@GetMapping({"/", "list"})
	public String list(Model model) {
		// 1. request param 수집/가공 
		// 2. business logic 처리 
		List<Board> list = service.listBoard();
		// 3. add attribute 
		model.addAttribute("boardList", list); 
		
		// 4. forward/redirect
		return "list";
	}
	
	@GetMapping("/id/{id}")
	public String board(@PathVariable("id") Integer id, Model model) {
		// 1. request param 
		// 2. business logic
		Board board = service.getBoard(id);
		// 3. add attribute
		model.addAttribute("board", board);
		// 4. forward/redirect
		System.out.println(board);
		
		return "get";
	}
	@GetMapping("/abc/{id}")
	public String abc(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("board", service.getBoard(id));
		return "abc";
	}
	
//	@RequestMapping(value = "/abc/{id}", method = RequestMethod.POST) 이것을 간결하게 하는것이 PostMapping
	@PostMapping("/abc/{id}")
	public String abcProcess(Board board, RedirectAttributes rttr) {
		
		boolean ok = service.abc(board);
		
		if(ok) {
			// 해당 게시물 보기로 리디렉션
			rttr.addAttribute("success", "success");
			return "redirect:/id/" + board.getId();
		} else { 
			// 수정 form 으로 리디렉션
			rttr.addAttribute("fail", "fail");
			return "redirect:/abc/" + board.getId();
		} 
	}
	
	@PostMapping("remove")
	public String remove(Integer id, RedirectAttributes rttr) {
		boolean ok = service.remove(id); 
		if(ok) {
			rttr.addAttribute("success", "remove");
			return "redirect:/list";
		} else {
			return "redirect:/id/" + id; 
		}
	}
	
}
