package com.inditex.endpoint.boot.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	
	@GetMapping("/")
	public String initialPage() {
		return "redirect:swagger-ui.html";
	}

}
