package kr.kwangan2.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/jsp/*")
public class AdminController {

	@GetMapping("/adminMain")
	public void doAdminMain() {
		log.info("admin Main");
	}
	
	@GetMapping("/boardManagement")
	public void doBoardManagement() {
		log.info("board management");
		
	}

	@GetMapping("/memberManagement")
	public void doMemberManagement() {
		
		log.info("member management");
	}
	
	
}//class
