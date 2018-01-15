package com.billtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@GetMapping(path="/")
	public String home() {
		return "App is launched successfully.";
	}
}