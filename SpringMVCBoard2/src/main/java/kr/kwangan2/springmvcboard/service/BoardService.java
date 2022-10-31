package kr.kwangan2.springmvcboard.service;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.BoardVO;

public interface BoardService {

//   @Select(" select * from board where bno>0 ")
	public List<BoardVO> boardVOList();

	public int insertBoardVO(BoardVO boardVO);

	public int insertBoardVOSelectKey(BoardVO boardVO);

	public BoardVO selectBoardVO(Long bno); // Mapper에서 이렇게 하면 xml에 #{bno}로 쓸수있게 해줌 ㅎ

	public int deleteBoardVO(Long bno);

	public int updateBoardVO(BoardVO boardVO);
}
