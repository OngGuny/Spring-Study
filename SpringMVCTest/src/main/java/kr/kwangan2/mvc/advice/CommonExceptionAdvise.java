package kr.kwangan2.mvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvise {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error(ex.getMessage());
		model.addAttribute("eception", ex);
		log.error(model);
		return "errorPage"; //이것과 이름이 같은 jsp 를 찾아서 열어줌 
	}
	
}//class
