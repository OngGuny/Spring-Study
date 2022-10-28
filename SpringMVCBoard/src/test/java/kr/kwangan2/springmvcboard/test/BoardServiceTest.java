package kr.kwangan2.springmvcboard.test;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.annotations.Delete;
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
	public void testInsertBoardVO() { // 에러뜸 
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("Service테스트 글제목");
		boardVO.setContent("contents");
		boardVO.setWriter("작성자");
		service.insertBoardVO(boardVO);
		log.info("생성된 게시물 번호 : "+boardVO.getBno());
	}
	
	@Test
	public void testBoardVOList() {
		service.boardVOList().forEach(boardVO->log.info(boardVO));
	}
	
	@Test
	public void testSelectBoardVO() { //에러 
		log.info(service.selectBoardVO(3L));
	}
	
	@Test
	public void testDeleteBoardVO(){
	//		service.deleteBoardVO();
	}
	
//	@Test
//	public void testUpdateVO() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setBno(11);
//		board.setTitle(")
//	}
	
}//class
