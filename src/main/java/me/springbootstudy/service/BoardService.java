package me.springbootstudy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	
	public Map<String, Object> listBoard(Integer page, String search) {
		// 페이지당 행의 수 
		Integer rowPerPage = 15;
	
		// 쿼리 LIMIT 절에 사용할 시작 인덱스 
		Integer startIndex = (page - 1) * rowPerPage;
		
		// 페이지네이션이 필요한 정보 
		// 전체 레코드 수 
		Integer numOfRecords = mapper.countAll(search);
		// 마지막 페이지 번호 
		Integer lastPageNumber = (numOfRecords - 1) / rowPerPage + 1;
		
		// 페이지네이션 왼쪽번호 
		Integer leftPageNum = page - 5; 
		// 여기서 1보다 작을 수 없으니까 
		leftPageNum = Math.max(leftPageNum, 1);
		
		// 페이지네이션 오른쪽 번호 
		Integer rightPageNum = leftPageNum + 9;
		// 마지막페이지보다 클 수 없음 
		rightPageNum = Math.min(rightPageNum, lastPageNumber);
		
		Map<String, Object> pageInfo = new HashMap<>();
		pageInfo.put("rightPageNum", rightPageNum); 
		pageInfo.put("leftPageNum", leftPageNum);
		pageInfo.put("currentPageNum", page);
		pageInfo.put("lastPageNum", lastPageNumber);
		
		// 게시물 목록 
		List<Board> list = mapper.selectAllPaging(startIndex, rowPerPage, search);
		
		return Map.of("pageInfo", pageInfo,
					  "boardList", list);
	}
}
