package kr.kwangan2.springmvcboard.mapper;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.BoardVO;

public interface BoardMapper {
	// @Select(" select * from board where bno>0 ")
	public List<BoardVO> boardVOList();

	public void insertBoardVO(BoardVO boardVO);

	public void insertBoardVOSelectKey(BoardVO boardVO);

	public BoardVO selectBoardVO(Long bno); // Mapper에서 이렇게 하면 xml에 #{bno}로 쓸수있게 해줌 ㅎ

	public int deleteBoardVO(Long bno);

	public int updateBoardVO(BoardVO boardVO);
}
