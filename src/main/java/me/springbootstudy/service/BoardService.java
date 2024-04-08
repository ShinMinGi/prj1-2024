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
		// TODO Auto-generated method stub
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
}
