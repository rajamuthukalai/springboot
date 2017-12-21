package com.billtracker.controller;

import com.billtracker.model.Biller;
import com.billtracker.repository.BiilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")
public class BillerController {


	@Autowired
	BiilerRepository repository;


	@GetMapping(path="/billers")
	public List<Biller> getBillers() {

		return repository.findAll();
	}

	@GetMapping(path="/biller/{id}")
	public Biller getBillers(@PathVariable(required =true) Long id) {

		return repository.findOne(id);
	}


	@PutMapping(path="/biller/{id}")
	public Biller updateBillers(@Valid  @RequestBody Biller biller) {

		return repository.save(biller);
	}

	@DeleteMapping(path="/biller/{id}")
	public void deleteBiller(@PathVariable Long id) {

		repository.delete(id);
	}


	@PostMapping(path="/biller")
	public Biller createBillers(@Valid @RequestBody Biller biller) {

		return repository.save(biller);
	}


}
