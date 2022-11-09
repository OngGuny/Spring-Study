
package kr.kwangan2.springmvcboard.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageVO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import kr.kwangan2.springmvcboard.mapper.ReplyMapper;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.Setter;

@Service
public class ReplyDAOImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardmapper;
	
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replymapper;

	@Override
	public ReplyPageVO listReplyVo(Criteria criteria, Long bno) {
		// TODO Auto-generated method stub
		return new ReplyPageVO(
				replymapper.replyVOListReplyCount(bno),
				replymapper.listReplyVo(criteria, bno)
				);
	}

	@Override
	public int replyVOListReplyCount(Long bno) {
		// TODO Auto-generated method stub
		return replymapper.replyVOListReplyCount(bno);
	}

	@Override
	public ReplyVO selectReplyVO(Long rno) {
		// TODO Auto-generated method stub
		return replymapper.selectReplyVO(rno);
	}

	@Override
	public Long insertReplyVO(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		boardmapper.updateReplyCnt(replyVO.getBno(), 1); //댓글 수 한개를 추가한다는것 
		return (long) replymapper.insertReplyVO(replyVO);
	}
	
	@Transactional
	@Override
	public Long deleteReplyVO(Long rno) {
		ReplyVO replyVO = replymapper.selectReplyVO(rno);
		boardmapper.updateReplyCnt(replyVO.getBno(),-1); // 댓글 지울 때. 
		return (long) replymapper.deleteReplyVO(rno);
	}

	@Override
	public Long updateReplyVO(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return (long) replymapper.updateReplyVO(replyVO);
	}

	
	
}// class
