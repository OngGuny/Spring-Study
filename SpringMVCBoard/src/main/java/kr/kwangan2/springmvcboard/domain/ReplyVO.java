package kr.kwangan2.springmvcboard.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replydate;
	private Date updatedate;
	public ReplyVO(Long rno, String reply, String replyer) {
		super();
		this.rno =rno;
		this.reply = reply;
		this.replyer = replyer;
	}
	public ReplyVO() {
	}
	
	
	
}
