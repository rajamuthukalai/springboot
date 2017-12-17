package com.billtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
	
	@GetMapping(path="/")
	public String test() {
		return "success";
	}
}
