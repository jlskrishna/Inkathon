package com.backend.inctathon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.bull.javamelody.MonitoredWithSpring;

@Controller
@MonitoredWithSpring
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "students";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/report")
	public String report() {
		return "Report";
	}
}
