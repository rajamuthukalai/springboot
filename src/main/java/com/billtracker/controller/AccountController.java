package com.billtracker.controller;


import com.billtracker.model.Account;
import com.billtracker.repository.AccountRepository;
import com.billtracker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountRepository repository;


    private AccountService service;

    @GetMapping(path = "/accounts")
    public List<Account> getAllAccounts(){
        return repository.findAll();
    }

    @GetMapping(path = "/account/{id}")
    public Account getAllAccount(@PathVariable Long id){
        return repository.findOne(id);
    }


    @PostMapping(path = "/account")
    public Account createAccount(@Valid @RequestBody Account account){

        return repository.save(account);
    }

    @PutMapping(path = "/account/{id}")
    public Account updateAccount(@Valid @RequestBody Account account){

        return repository.save(account);
    }

    @DeleteMapping(path = "/account/{id}")
    public void deleteAccount(@PathVariable Long id) {
        repository.delete(id);
    }

}
