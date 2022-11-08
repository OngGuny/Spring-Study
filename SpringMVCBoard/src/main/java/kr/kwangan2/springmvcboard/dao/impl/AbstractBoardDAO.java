package kr.kwangan2.springmvcboard.dao.impl;

import java.util.List;

import kr.kwangan2.springmvcboard.dao.BoardDAO;
import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;

public class AbstractBoardDAO implements BoardDAO {

	@Override
	public List<BoardVO> boardVOList(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardVOListCount(Criteria criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> boardVOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return	0;
	}

	@Override
	public int inserBoardVOSelectKey(BoardVO boardvo) {
		// TODO Auto-generated method stub
		return	0;
	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoardVO(BoardVO boardvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateReplyCnt(long bno, int amount) {
	}
	
}//class
