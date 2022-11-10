package kr.kwangan2.springmvcboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import kr.kwangan2.springmvcboard.service.BoardService;
import lombok.Setter;

public class ApstactBoardService implements BoardService {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public List<BoardVO> boardVOList() {
		return null;
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		return 0;
	}

	@Override
	public int inserBoardVOSelectKey(BoardVO boardvo) {
		return 0;
	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		return null;
	}

	@Override
	public int deleteBoardVO(Long bno) {
		return 0;
	}

	@Override
	public int updateBoardVO(BoardVO boardvo) {
		return 0;
	}

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
	public void updateReplyCnt(long bno, int amount) {
	}
	
}//class
