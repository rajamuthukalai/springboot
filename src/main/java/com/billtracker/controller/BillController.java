package com.billtracker.controller;

import com.billtracker.model.Biller;
import com.billtracker.repository.BiilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {


	@Autowired
	BiilerRepository repository;
	
	@GetMapping(path="/")
	public String test() {
		return "success";
	}


	@GetMapping(path="/billers")
	public List<Biller> getBillers() {

		return repository.findAll();
	}

	@GetMapping(path="/biller/{id}")
	public Biller getBillers(@PathVariable Long id) {

		return repository.findOne(id);
	}


	@PutMapping(path="/biller/{id}")
	public Biller updateBillers(@RequestBody Biller biller) {

		return repository.save(biller);
	}

	@DeleteMapping(path="/biller/{id}")
	public void deleteBiller(@PathVariable Long id) {
		 repository.delete(id);
	}


	@PostMapping(path="/biller")
	public Biller createBillers(@RequestBody Biller biller) {

		return repository.save(biller);
	}


}
