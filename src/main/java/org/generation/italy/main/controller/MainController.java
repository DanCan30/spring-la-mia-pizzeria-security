package org.generation.italy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/user")
	public String getUser() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}
}
