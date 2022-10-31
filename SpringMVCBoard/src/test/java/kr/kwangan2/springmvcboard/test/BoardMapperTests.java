package kr.kwangan2.springmvcboard.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testBoardVOList() {
		mapper.boardVOList().forEach(board->log.info(board));//?? 뭔함수?
	}
	
	public void testInsertBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새글");
		boardVO.setContent("새내용");
		boardVO.setWriter("이름");
		mapper.insertBoardVOSelectKey(boardVO);
		log.info(boardVO);
	
	}
	@Test
	public void testBoardVOSelectKey() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새로운제목");
		boardVO.setContent("새로운내용");
		boardVO.setWriter("새이름");
		mapper.insertBoardVOSelectKey(boardVO);
		log.info(boardVO);
	}
	
}// class
