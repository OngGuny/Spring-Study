package kr.kwangan2.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/file/*")
public class FIleUploadFormController {
	@RequestMapping(value = "/fileUploadForm")
	public String fileUploadForm() {
		return "fileUploadForm";
	}

}
