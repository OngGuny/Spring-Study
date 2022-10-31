package kr.kwangan2.springmvcboard.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testInsertBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("Service ����");
		boardVO.setContent("Service ����");
		boardVO.setWriter("Service �ۼ���");
		service.insertBoardVO(boardVO);
		log.info("������ �Խù� ��ȣ : " + boardVO.getBno());
	}
	//@Test
	public void testBoardVOList() {
		service.boardVOList().forEach(boardVO -> log.info(boardVO));;
	}
	@Test
	public void testSelectBoardVO() {
		log.info(service.selectBoardVO(1L));
	}
	
	@Test
	public void testDeleteBoardVO() {
		service.deleteBoardVO(30L);
	}
	
	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(3L);
		boardVO.setTitle("��");
		boardVO.setContent("��");
		boardVO.setWriter("��");
		service.insertBoardVO(boardVO);
	}
}








