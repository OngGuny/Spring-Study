package kr.kwangan2.rest.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.rest.domain.Person;
import kr.kwangan2.rest.domain.Ticket;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/test")
@Log4j
public class RestTestController {

	@GetMapping(value = "/plainText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "Helloo~~~~~~~~~";
	}
	
	@RequestMapping(value="/object", 
			produces={
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE
			}) //위의 2개 타입으로 받겠다는것 
	public Person getObject( ) {
		return new Person("Neo",30);  
	}// 이거하고 .json 붙여주면 제이슨형식으로 나온다.

	//list로 줘보자. 
	@RequestMapping(value="/getList" 
			)
	public List<Person> getList(){
		return IntStream.range(1, 10).mapToObj(i->new Person("이름"+i,i))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/getMap")
	public Map<String, Person> getMap() {
		Map<String, Person> map = new HashMap<String, Person>();
		map.put("D", new Person("디오",29));
		map.put("O", new Person("JOJO",20));
		map.put("MM", new Person("Go",21));
		return map;
	}//잭슨바인딩 안써도 다 바인딩해서 준다. rest방식 써서 
	
	
	//데이터 내용 검증용  http://localhost:8888/test/responseEntity?height=151&weight=100 해줘야 구분가능. 
	@RequestMapping(value="/responseEntity", params= {"height","weight"})
	public ResponseEntity<Person> responseEntity(double height, double weight){
		Person person = new Person("무다무다무다", 44);
		ResponseEntity<Person> result = null;
		if(height <150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(person);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(person);
			
		}
		return result;
	}
	
	//path variable 사용해보기   http://localhost:8888/test/getPath/ccccat/igi
	@RequestMapping(value="/getPath/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") String pid
			) {
		return new String[] {"category: "+cat, "pid : "+ pid};
	}
	
	@PostMapping("/requestBody")
	public Ticket reqeustBody(@RequestBody Ticket ticket) { //get 하면 헤더만 넘어오니까 바디를 못넘기자나! 그래서 postmapping 하는것 
		return ticket;
	}
	
}// class
