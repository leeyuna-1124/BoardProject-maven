package com.example.parameter;

import java.util.List;

import com.example.domain.Board;

import lombok.Data;

/**
 * 게시물 검색 파라미터
 *
 */
@Data
public class BoardSearchParameter {
	
	private String keyword;
	private List<Board> boardTypes;
	
	public BoardSearchParameter() {
		
	}

}
