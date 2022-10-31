package kr.kwangan2.springmvcboard.service.impl;

import java.util.List;


import kr.kwangan2.springmvcboard.domain.BoardVO;


public class BoardServiceImpl extends ApstactBoardService {

	@Override
	public List<BoardVO> boardVOList() {
		// TODO Auto-generated method stub
		return super.boardVOList();
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return super.insertBoardVO(boardVO);
	}

	@Override
	public int inserBoardVOSelectKey(BoardVO boardvo) {
		// TODO Auto-generated method stub
		return super.inserBoardVOSelectKey(boardvo);
	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return super.selectBoardVO(bno);
	}

	@Override
	public int deleteBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return super.deleteBoardVO(bno);
	}

	@Override
	public int updateBoardVO(BoardVO boardvo) {
		// TODO Auto-generated method stub
		return super.updateBoardVO(boardvo);
	}
	
}
