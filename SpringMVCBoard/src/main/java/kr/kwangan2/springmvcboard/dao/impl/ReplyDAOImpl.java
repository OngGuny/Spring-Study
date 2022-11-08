
package kr.kwangan2.springmvcboard.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageVO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.mapper.ReplyMapper;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.Setter;

@Service
public class ReplyDAOImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Override
	public ReplyPageVO listReplyVo(Criteria criteria, Long bno) {
		// TODO Auto-generated method stub
		return new ReplyPageVO(
				mapper.replyVOListReplyCount(bno),
				mapper.listReplyVo(criteria, bno)
				);
	}

	@Override
	public int replyVOListReplyCount(Long bno) {
		// TODO Auto-generated method stub
		return mapper.replyVOListReplyCount(bno);
	}

	@Override
	public ReplyVO selectReplyVO(Long rno) {
		// TODO Auto-generated method stub
		return mapper.selectReplyVO(rno);
	}

	@Override
	public Long insertReplyVO(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return (long) mapper.insertReplyVO(replyVO);
	}

	@Override
	public Long deleteReplyVO(Long rno) {
		// TODO Auto-generated method stub
		return (long) mapper.deleteReplyVO(rno);
	}

	@Override
	public Long updateReplyVO(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return (long) mapper.updateReplyVO(replyVO)
				;
	}

}// class
