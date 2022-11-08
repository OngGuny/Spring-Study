package kr.kwangan2.springmvcboard.service;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageVO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;

public interface ReplyService {
	public ReplyPageVO listReplyVo(Criteria criteria, Long bno);

	public int replyVOListReplyCount(Long bno);
	
	public ReplyVO selectReplyVO(Long rno);
	
	public Long insertReplyVO(ReplyVO reply);
	
	public Long updateReplyVO(ReplyVO replyVO);
	
	public Long deleteReplyVO(Long rno);
	
}
