package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Board;
import com.example.parameter.BoardParameter;
import com.example.parameter.BoardSearchParameter;
import com.example.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository repository;
	
	/**
	 * 목록 리턴
	 * @return
	 *
	 */	
	public List<Board> getList(BoardSearchParameter parameter){
		return repository.getList(parameter);
	}
	
	/**
	 * 상세정보 리턴
	 * @param boardIdx
	 * @return
	 *
	 */	
	public Board get(int boardIdx) {
		return repository.get(boardIdx);
	}
	
	/**
	 * 등록/수정 처리
	 * @param board
	 * @return
	 *
	 */	
	public void save(BoardParameter param) {
	//조회하여 리턴된 정보
	Board board = repository.get(param.getBoardIdx());
	if (board == null) {
		repository.save(param);
	} else {
		repository.update(param);
	}
    }
	
	
	/**
	 * 삭제 처리
	 * @param boardIdx
	 * @return
	 *
	 */	
	public void delete(int boardIdx) {
		repository.delete(boardIdx);
	}
	
	/**
	 * 단순 반복을 이용한 등록 처리
	 *
	 */
	public void saveList1(List<BoardParameter> list) {
		for(BoardParameter parameter : list) {
			repository.save(parameter);
		}
			
	}
	
	/**
	 * 10000개의 배열에 담아서 일괄 등록 처리
	 *
	 */
	public void saveList2(List<BoardParameter> boardList) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardList", boardList);
		repository.saveList(paramMap);
	}
}
