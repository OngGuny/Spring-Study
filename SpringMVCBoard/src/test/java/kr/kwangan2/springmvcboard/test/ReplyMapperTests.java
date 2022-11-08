package kr.kwangan2.springmvcboard.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageVO;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	ReplyService rs;
	
//	@Test
//	public void testListReplyVO() {
//		
//		Criteria criteria = new Criteria();
//		Long bno = 44L;
//		List<ReplyVO> list = rs.listReplyVo(criteria, bno );
//		assertNotNull(list);
//	} //완 
//	
////	@Test
//	public void testSelect() {
//	ReplyVO rv=	rs.selectReplyVO((long)75);
//	log.info(rv);
//	} //완
//	
//	@Test
//	public void testReplyVOList() {
//		int result = rs.replyVOListReplyCount(44L);
//		assertNotNull(result>0);
//		log.info(result);
//	} //완
//	
//	@Test
//	public void testinsertVO() {
//		ReplyVO rv = new ReplyVO();
//		rv.setBno(44L);
//		rv.setReply("댓글 이요~");
//		rv.setReplyer("작성자요~");
//		rs.insertReplyVO(rv);
//		Long re = rs.insertReplyVO(rv);
//		assertNotNull(re>0);
//	} // 완
//
//	
//	@Test
//	public void testupdate() {
//		ReplyVO rv = new ReplyVO(1L,"111수정요","111수정작상저");
//		rs.updateReplyVO(rv);
//		Long re = rs.insertReplyVO(rv);
//		assertNotNull(re>0);
//	} // 되는데 오류뜸 
//	
//	@Test
//	public void testdelete() {
//		Long re = rs.deleteReplyVO(1L);
//		assertNotNull(re>0);
//	} // 완 
	
	@Test
	public void testList2() {
		Criteria criteria = new Criteria(1,5);
		List<ReplyPageVO> replies = (List<ReplyPageVO>) rs.listReplyVo(criteria, 44L);
		replies.forEach(reply -> log.info(reply)); //리스트 안에 있는 거 하나하나를 reply 라고 하자 거기있는걸 로그로 찍어보자
	}
	
}//class
