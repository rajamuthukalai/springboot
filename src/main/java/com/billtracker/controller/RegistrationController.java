package com.billtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@GetMapping("/signup")
	public String signUp() {
		return "Sign Up is in progresS";
	}
}