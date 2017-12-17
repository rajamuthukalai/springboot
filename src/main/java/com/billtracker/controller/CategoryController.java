package com.billtracker.controller;

import com.billtracker.model.Biller;
import com.billtracker.model.Category;
import com.billtracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kgtl075 on 17/12/17.
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping(path="/categories")
    public List<Category> getCategories() {

        return repository.findAll();
    }

    @GetMapping(path="/category/{id}")
    public Category getCategory(@PathVariable Long id) {

        return repository.findOne(id);
    }


    @PutMapping(path="/category/{id}")
    public Category updateCategory(@RequestBody Category category) {

        return repository.save(category);
    }

    @DeleteMapping(path="/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        repository.delete(id);
    }


    @PostMapping(path="/category")
    public Category createCategory(@RequestBody Category category) {

        return repository.save(category);
    }
}
