package com.taco.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TacoCloudHomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
