package kr.kwangan2.springmvcboard.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private long replycnt;
}

