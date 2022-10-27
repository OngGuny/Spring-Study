package kr.kwangan2.mvc.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kwangan2.mvc.domain.PersonDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/test/*", method = { RequestMethod.GET, RequestMethod.POST }) // localhost:8080/test/
@Log4j
public class TestController {

	@RequestMapping(value = "/test1", method = { RequestMethod.GET }) // get 요청 8080/test/test1
	public void test1() {

		log.info("testGet() 호출!");
	}

	@RequestMapping(value = "/test2", method = { RequestMethod.POST }) // poet 요청8080/test/test2
	public void test2() {
		log.info("testPost() 호출!");

	}

	@RequestMapping(value = "/personParam")
	public void testPersonDTO(@RequestParam("name") String id, int age) {
		log.info(id + ":" + age);
		// 걍 파라미터로 네임, 에이지 넣어주면 같은 필드 찾아서 넣어준다... 개사기
		// 리퀘스트가 name 으로 보냈을ㅊ 때 여기서 id 로 받고 세팅하겠다는것. 이름 같게하거나 requestparam으로 맵핑하거나.
	}

	@RequestMapping(value = "/personDTO")
	public void testPersonDTO(PersonDTO personDTO) {
		log.info(personDTO);// 걍 파라미터로 네임, 에이지 넣어주면 같은 필드 찾아서 넣어준다... 개사기
	}

	@RequestMapping(value = "/fileupload")
	public void testFileUpload(@RequestParam("uploadFile") ArrayList<String> listUploadFiles) {
		log.info(listUploadFiles);
	}

	@RequestMapping(value = "/personDTOList")
	public void testPersonDTOList(PersonDTO personDTOList) {
		log.info(personDTOList);
	}

//	@IdrtyhjnitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
//	
	@GetMapping("/initBinder")
	public void binder(PersonDTO personDTO) {
		log.info(personDTO);
	}

	@GetMapping("/getModelInfo")
	public String getModelInfo(Model model, @ModelAttribute("addr") String addr) {
		model.addAttribute("name", "킬동 홍");
		model.addAttribute("age", "19");
		log.info(addr);
		return "getModelInfo";
	}

	@GetMapping("/getInfo")
	public String getInfo(Model model, String name, int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "redirect:/";
	}

	@GetMapping("/getJson")
	public @ResponseBody PersonDTO getJson() {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setName("킬동 홍");
		personDTO.setAge(23);
		personDTO.setBirth(new Date());
		PersonDTO personDTO2 = new PersonDTO();
		personDTO2.setName("니나");
		personDTO2.setAge(23);
		personDTO2.setBirth(new Date());
		PersonDTO personDTO3 = new PersonDTO();
		personDTO3.setName("인홍");
		personDTO3.setAge(25);
		personDTO3.setBirth(new Date());

		ArrayList<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
		personDTOList.add(personDTO2);
		personDTOList.add(personDTO3);

		personDTO.setPersonDTOList(personDTOList);
		return personDTO;
	}// DTO 만 툭 던져두니까 jsp 는 뭘써야?? 걍띄움; 제이슨 뷰가 되어버림

	// 아래는 Spring2.5 , 3.0 버젼 
	@GetMapping("modelAndView")
	public ModelAndView modelAndView(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 20);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAndView");
		// mav.setStatus(HttpStatus.OK);

		return mav;
	}
	
	@GetMapping("/realUploadForm")
	public String realUploadForm() {
		
		
		return "fileUploadForm";
	}
	
	@PostMapping("/realfileupload")
	public void realfileupload(ArrayList<MultipartFile> uploadFile) {
		uploadFile.forEach(file->{
			
		log.info("업로드 할 때의 파일 명 :   " + file.getOriginalFilename());
		log.info("업로드 할 때의 파일 크기 :   " + file.getSize());
		});	
		
		
	}//realfileupload  
	
	
}// class


