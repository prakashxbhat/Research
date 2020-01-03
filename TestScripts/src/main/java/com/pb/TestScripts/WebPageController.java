package com.pb.TestScripts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebPageController {

	@GetMapping(value = { "/", "/index" }) // URL path
	public String index() {
		return "index"; // HTML page
	}
}
