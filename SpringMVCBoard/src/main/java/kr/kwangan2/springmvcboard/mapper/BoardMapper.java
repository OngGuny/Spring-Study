package kr.kwangan2.springmvcboard.mapper;

import java.util.List;


import kr.kwangan2.springmvcboard.domain.BoardVO;

public interface BoardMapper {
	//@Select(" select * from board where bno>0 ")
	public List<BoardVO> boardVOList();
	
	public int insertBoardVO(BoardVO boardVO);
	
	public int inserBoardVOSelectKey(BoardVO boardvo);
	
	public BoardVO selectBoardVO(Long bno);
	
	public int deleteBoardVO(Long bno);
	
	public int updateBoardVO(BoardVO boardvo);
}
