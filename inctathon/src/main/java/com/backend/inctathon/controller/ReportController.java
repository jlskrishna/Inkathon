package com.backend.inctathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.backend.inctathon.repository.ReportRepo;

@RestController
public class ReportController {

	@Autowired
	private ReportRepo reportRepo;
	
	@GetMapping("/Report")
	public ResponseEntity<String> login() {
		return new ResponseEntity<String>("Welcom !!!", HttpStatus.OK);
	}

	@GetMapping("/reports")
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("Report");
		mav.addObject("report_entity", reportRepo.findAll());
		return mav;
	}
}