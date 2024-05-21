package me.springbootstudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.springbootstudy.domain.Board;
import me.springbootstudy.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper; 
	
	public List<Board> listBoard() {
		List<Board> list = mapper.selectAll();
		return list;
	}

	public Board getBoard(Integer id) {
		return mapper.selectById(id); 
	}

	public Boolean abc(Board board) {
		int cnt = mapper.update(board);
		
		
		return cnt == 1;
		
	}

	public boolean remove(Integer id) {
		int cnt = mapper.deleteById(id);
		return cnt == 1;
	}

	
	public boolean addBoard(Board board) {
		int cnt = mapper.insert(board); 
				
		return cnt == 1;
	}

	
	public List<Board> listBoard(Integer page) {
		Integer startIndex = (page - 1) * 10;
		// 게시물 목록 
		return mapper.selectAllPaging(startIndex);
		// 페이지네이션이 필요한 정보 
	}
}
