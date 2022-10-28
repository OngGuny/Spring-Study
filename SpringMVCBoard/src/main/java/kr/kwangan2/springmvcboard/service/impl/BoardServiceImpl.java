package kr.kwangan2.springmvcboard.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.kwangan2.springmvcboard.domain.BoardVO;

public class BoardServiceImpl extends AbstractBoardService {

	@Override
	public List<BoardVO> boardVOList() {
		// TODO Auto-generated method stub
		return super.boardVOList();
	}

	@Override
	public void insertBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub
		super.insertBoardVO(boardVO);
	}

	@Override
	public void insertBoardVOSelectKey(BoardVO boardVO) {
		// TODO Auto-generated method stub
		super.insertBoardVOSelectKey(boardVO);
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
	public int updateBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return super.updateBoardVO(boardVO);
	}

}
