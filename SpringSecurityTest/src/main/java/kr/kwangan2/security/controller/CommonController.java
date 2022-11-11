package kr.kwangan2.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("접근거부 ㅅㄱ " + auth );
		
		model.addAttribute("msg","Access Denied");
		
	}//error
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error : "+ error);
		log.info("logout : "+ logout);
		if(error!=null) {
			model.addAttribute("error", "계정을 확인하세요");
		}
		if(logout!=null) {
			model.addAttribute("logout", "LogOUt..");
		}
	}//customlogin
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout");
	}
	
}//class
