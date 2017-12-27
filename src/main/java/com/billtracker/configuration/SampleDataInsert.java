package com.billtracker.configuration;

import com.billtracker.model.Biller;
import com.billtracker.model.Category;
import com.billtracker.repository.BiilerRepository;
import com.billtracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleDataInsert implements CommandLineRunner {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private BiilerRepository billerRepository;

    @Override
    public void run(String... strings) throws Exception {

        Biller biller = new Biller();
        biller.setName("vodofone");
        billerRepository.save(biller);

        Category category = new Category();

        category.setName("mobile");

        repository.save(category);
    }
}
