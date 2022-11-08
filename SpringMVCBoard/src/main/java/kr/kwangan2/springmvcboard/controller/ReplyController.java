package kr.kwangan2.springmvcboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageVO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
//@AllArgsConstructor
public class ReplyController {

	@Setter(onMethod_ = @Autowired)
	private ReplyService rs;

	@PostMapping(
				value="/insert",
				consumes= {MediaType.APPLICATION_JSON_UTF8_VALUE},
				produces = {MediaType.TEXT_PLAIN_VALUE}
			)
	
	public ResponseEntity<String> insertReplyVO(@RequestBody ReplyVO replyVO){
		Long result = rs.insertReplyVO(replyVO);
		return result ==1
				? new ResponseEntity<String>("success",HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR)
			;		
	}
	
	@GetMapping(
			value="/pages/{bno}/{page}",
			produces= {
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE
			}
			)
		public ResponseEntity<ReplyPageVO>	 listReplyVO(
				@PathVariable("bno") long bno,
				@PathVariable("page") int page
				){
		Criteria criteria = new Criteria(page, 10);
		return new ResponseEntity<>(
				rs.listReplyVo(criteria, bno),HttpStatus.OK
				);
		
	}
	

	@GetMapping(
			value="/{rno}",
			produces= {
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE
			}
		)
	public ResponseEntity<ReplyVO> selectReplyVO(
			@PathVariable("rno") Long rno // "rno" d에 들어오면 long rno 에 넣겠따는것 
 			){
		return new ResponseEntity(rs.selectReplyVO(rno),HttpStatus.OK);
		
	}

	
	@DeleteMapping(
			value="/{rno}",
			produces= {MediaType.TEXT_PLAIN_VALUE}
			)
	public ResponseEntity<ReplyVO> deleteReplyVO(
			@PathVariable("rno") Long rno  // "rno" d에 들어오면 long rno 에 넣겠따는것 
 			){
		return rs.deleteReplyVO(rno)==1
				? new ResponseEntity("success", HttpStatus.OK)
				: new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
			;
	}
	
	@RequestMapping(
				value="/{rno}",
				method= {RequestMethod.PUT, RequestMethod.PATCH},
				consumes= {MediaType.APPLICATION_JSON_UTF8_VALUE},
				produces= {MediaType.TEXT_PLAIN_VALUE}
			)
	public ResponseEntity<String> updateReplyVO(
			@RequestBody ReplyVO replyVO,
			@PathVariable("rno") Long rno 
			){
		return rs.updateReplyVO(replyVO)==1
				? new ResponseEntity("success", HttpStatus.OK)
				: new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
			;
	}
		
	

}// class
