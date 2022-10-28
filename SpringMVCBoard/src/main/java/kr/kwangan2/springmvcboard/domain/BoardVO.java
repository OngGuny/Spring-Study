package kr.kwangan2.springmvcboard.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}//자바 클래스 소스 보면 뭐 만들어져있는지 다 나온다.. 
