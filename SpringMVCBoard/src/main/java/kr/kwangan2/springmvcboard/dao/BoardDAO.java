package kr.kwangan2.springmvcboard.dao;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.service.BoardService;

public interface BoardDAO extends BoardService{
	public List<BoardVO> boardVOList();

	public int insertBoardVO(BoardVO boardVO);

	public int insertBoardVOSelectKey(BoardVO boardVO);

	public BoardVO selectBoardVO(Long bno); // Mapper에서 이렇게 하면 xml에 #{bno}로 쓸수있게 해줌 ㅎ

	public int deleteBoardVO(Long bno);

	public int updateBoardVO(BoardVO boardVO);

}
