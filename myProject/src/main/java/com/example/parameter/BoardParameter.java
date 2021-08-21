package com.example.parameter;

import lombok.Data;

@Data
public class BoardParameter {
	
	private int boardIdx;
	private String title;
	private String content;
	
	//기본 생성자
	public BoardParameter() {
		
	}
	//테스트용 생성자
	public BoardParameter(String title, String content) {
		this.title = title;
		this.content = content;
	}

}
