package kr.kwangan2.springmvcboard.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;
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
//	@Test
//	public void testinsertBoardVO() {
//		boardVO = new BoardVO();
//		boardVO.setTitle("����");
//		boardVO.setContent("������");
//		boardVO.setWriter("������");
//		mapper.insertBoardVO(boardVO);
//		log.info(boardVO);
//	}
	/*
	 * @Test public void testBoardVOSelectkey() { boardVO = new BoardVO();
	 * boardVO.setTitle("������SK"); boardVO.setContent("�ų���SK");
	 * boardVO.setWriter("���ۼ���SK"); mapper.inserBoardVOSelectKey(boardVO);
	 * log.info(boardVO); }
	 */
	@Test
	public void testSelectBoard() {
		boardVO=mapper.selectBoardVO(4L);
		log.info(boardVO);
	}
//	@Test
//	public void testDeleteBoard() {
//		int result = mapper.deleteBoardVO(35L);
//		log.info(result);
//	}
//	@Test
//	public void testUpdateBoard() {
//		boardVO = new BoardVO();
//		boardVO.setBno(1L);
//		boardVO.setTitle("������ ��");
//		boardVO.setContent("������ ����");
//		boardVO.setWriter("������ �۾���");
//		mapper.updateBoardVO(boardVO);
//	}
//	
	@Test
	public void testPaging() {
		Criteria criteria = new Criteria(3,3);
		
		mapper.boardVOList(criteria).forEach(board -> log.info(board));
		log.info("뭐꼬 페이징 된거 맞나?");// 20줄 부터 위로 10개 받아온다 
	}
	
	
}//class















