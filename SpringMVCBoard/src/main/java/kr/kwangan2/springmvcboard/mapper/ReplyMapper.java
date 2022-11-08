package kr.kwangan2.springmvcboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageVO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;

public interface ReplyMapper {
	
//	public ReplyPageVO 
	
	public List<ReplyVO> listReplyVo(
				@Param("criteria") Criteria criteria,
				@Param("bno") Long bno
			);
	
	//전체 댓글 수 가져오는메소드
		
	public int replyVOListReplyCount(Long bno);
	
	public ReplyVO selectReplyVO(Long rno);
	
	public int insertReplyVO(ReplyVO reply);
	
	public int updateReplyVO(ReplyVO replyVO);
	
	public int deleteReplyVO(Long rno);
	
	
	
}//class
