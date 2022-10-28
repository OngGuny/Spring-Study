package kr.kwangan2.springmvcboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import kr.kwangan2.springmvcboard.service.BoardService;
import lombok.Setter;

public class AbstractBoardService implements BoardService{
	//얘는 인터페이스 넣을 수 가 없다. 그래서 추상클래스에 넣어주는거 
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> boardVOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBoardVOSelectKey(BoardVO boardVO) {
		// TODO Auto-generated method stub
		
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
	public int updateBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
