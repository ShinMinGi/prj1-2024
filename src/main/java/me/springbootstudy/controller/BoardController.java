package me.springbootstudy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.springbootstudy.domain.Board;
import me.springbootstudy.service.BoardService;

@Controller
@RequestMapping("/")
public class BoardController {


	@Autowired
	private BoardService service; 
	// 경로 : http://localhost:8080?page=?
	// 경로 : http://localhost:8080/list?page=?
	// 게시물 목록 
//	@RequestMapping(value = {"/", "list"}, method = RequestMethod.GET)
	@GetMapping({"/", "list"})
	public String list(Model model, @RequestParam(value="page", defaultValue="1") Integer page,
									@RequestParam(value="search", defaultValue="") String search ) {
		// 1. request param 수집/가공 
		// 2. business logic 처리 
//		List<Board> list = service.listBoard();	 //페이지 처리 전 
		Map<String, Object> result = service.listBoard(page,search); // 페이지 처리 
		// 3. add attribute 
//		model.addAttribute("boardList", result.get("boardList"));
//		model.addAttribute("pageInfo", result.get("pageInfo"));
		model.addAllAttributes(result);
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
//			rttr.addAttribute("success", "success");
			rttr.addFlashAttribute("message", board.getId()  + "번 게시물이 수정되었습니다.");
			return "redirect:/id/" + board.getId();
		} else { 
			// 수정 form 으로 리디렉션
			rttr.addFlashAttribute("message", board.getId() + "번 게시물 수정을 실패하였습니다.");
			return "redirect:/abc/" + board.getId();
		} 
	}
	
	@PostMapping("remove")
	public String remove(Integer id, RedirectAttributes rttr) {
		boolean ok = service.remove(id); 
		if(ok) {
			// query string에 추가 
			// rttr.addAttribute("success", "remove");
			
			// 모델에 추가 
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되었습니다.");
			return "redirect:/list";
		} else {
			return "redirect:/id/" + id; 
		}
	}
	
	@GetMapping("add")
	public void addForm(Board board) {
		// 게시물 작성 form (view) 로 포워드 
	}

	// String return 타입이라 public String 
	@PostMapping("add")
	public String addProcess(Board board, RedirectAttributes rttr) {
		
		boolean ok = service.addBoard(board);
		
		if(ok) {
			rttr.addFlashAttribute("message", board.getId() + "번 게시글을 작성했습니다.");
			return "redirect:/id/" + board.getId();
		} else {
			rttr.addFlashAttribute("board", board);
			return "redirect:/add";
		}
	}
	
//	// 페이징 처리 
//	@GetMapping("list")
//	pub
//		Integer startIndex = (page - 1) * 20;
//	}
//	
//	
}


