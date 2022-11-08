package kr.kwangan2.springmvcboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;

public interface BoardMapper {
	//@Select(" select * from board where bno>0 ")
	public List<BoardVO> boardVOList();
	
	public List<BoardVO> boardVOList(Criteria criteria);
	
	public int boardVOListCount(Criteria criteria);
	
	public int insertBoardVO(BoardVO boardVO);
	
	public int inserBoardVOSelectKey(BoardVO boardvo);
	
	public BoardVO selectBoardVO(Long bno);
	
	public int deleteBoardVO(Long bno);
	
	public int updateBoardVO(BoardVO boardvo);
	
	 public void updateReplyCnt(@Param("bno") long bno , @Param("amount") int amount); //2개 인자 여러개 보내려면. @param 써줘야함. 
}
