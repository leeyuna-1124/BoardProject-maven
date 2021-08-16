package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	
	private int boardIdx;
	private String title;
	private String content;
	private Date regDate;

}
