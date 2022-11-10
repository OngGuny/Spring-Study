package kr.kwangan2.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class JSPController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("아 수준 미달" + auth);
		
		model.addAttribute("msg","Access Denied");
	}//error

	@GetMapping("/adminLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error : "+ error);
		log.info("logout : "+ logout);
		
		if(error != null) {
			model.addAttribute("error","수준미달 ㅈㅅ ");
		}
		if(logout !=null) {
			model.addAttribute("logout", "LogOut...!");
		}
		
	
	}//adminlogin
	
	@GetMapping("/adminLogout")
	public void logoutGet() {
		log.info("admin logout ");
	}


	
}//class
