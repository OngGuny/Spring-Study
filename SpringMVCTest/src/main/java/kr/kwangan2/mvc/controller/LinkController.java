package kr.kwangan2.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/link/*")
public class LinkController {
	@RequestMapping(value = "/viewLink")
	public String viewLink() {
		return "viewLink";
	}

}
