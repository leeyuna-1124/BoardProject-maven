package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Board;
import com.example.parameter.BoardParameter;
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
	public List<Board> getList(){
		return repository.getList();
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

}
