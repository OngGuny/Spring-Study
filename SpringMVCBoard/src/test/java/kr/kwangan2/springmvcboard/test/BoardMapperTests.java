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
	private BoardVO boardVO;
	
	@Test
	public void testGetList() {
		mapper.boardVOList().forEach(board -> log.info(board));
	}
	@Test
	public void testinsertBoardVO() {
		boardVO = new BoardVO();
		boardVO.setTitle("새글");
		boardVO.setContent("새내용");
		boardVO.setWriter("전민재");
		mapper.insertBoardVO(boardVO);
		log.info(boardVO);
	}
	@Test
	public void testBoardVOSelectkey() {
		boardVO = new BoardVO();
		boardVO.setTitle("신제목SK");
		boardVO.setContent("신내용SK");
		boardVO.setWriter("신작성자SK");
		mapper.inserBoardVOSelectKey(boardVO);
		log.info(boardVO);
	}
	@Test
	public void testSelectBoard() {
		boardVO=mapper.selectBoardVO(4L);
		log.info(boardVO);
	}
	@Test
	public void testDeleteBoard() {
		int result = mapper.deleteBoardVO(35L);
		log.info(result);
	}
	@Test
	public void testUpdateBoard() {
		boardVO = new BoardVO();
		boardVO.setBno(1L);
		boardVO.setTitle("수정된 글");
		boardVO.setContent("수정된 내용");
		boardVO.setWriter("수정된 글쓴이");
		mapper.updateBoardVO(boardVO);
	}
}















