package kr.kwangan2.springmvcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import kr.kwangan2.springmvcboard.mapper.ReplyMapper;
import lombok.Setter;

@Service
public class BoardDAOImpl extends AbstractBoardDAO {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardmapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replymapper;

	@Override
	public List<BoardVO> boardVOList() {

		return boardmapper.boardVOList();
	}

	@Override
	public List<BoardVO> boardVOList(Criteria criteria) {
		return boardmapper.boardVOList(criteria);
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		return boardmapper.insertBoardVO(boardVO);
	}

	@Override
	public int inserBoardVOSelectKey(BoardVO boardvo) {
		return boardmapper.inserBoardVOSelectKey(boardvo);
	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return boardmapper.selectBoardVO(bno);
	}

	@Override
	public int deleteBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return boardmapper.deleteBoardVO(bno);
	}

	@Override
	public int updateBoardVO(BoardVO boardvo) {
		// TODO Auto-generated method stub
		return boardmapper.updateBoardVO(boardvo);
	}

	@Override
	public int boardVOListCount(Criteria criteria) {
		// TODO Auto-generated method stub
		return boardmapper.boardVOListCount(criteria);
	}

	@Override
	public void updateReplyCnt(long bno, int amount) {
		boardmapper.updateReplyCnt(bno, amount);
		return; //void 는 그냥 값이 없다. 리턴을 안하는게 아니라 .
	}
	
}//class
