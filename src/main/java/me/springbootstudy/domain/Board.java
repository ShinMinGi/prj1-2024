package me.springbootstudy.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Board {
	private Integer id;
	private String title; 
	private String body;
	private LocalDateTime inserted;
	private String writer;
}

