package com.billtracker.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.billtracker.model.Biller;
import com.billtracker.repository.BiilerRepository;

@Configuration
public class SampleDataInsert implements CommandLineRunner {

    @Autowired
    private BiilerRepository billerRepository;

    @Override
    public void run(String... strings) throws Exception {

        Biller biller = new Biller();
        biller.setName("vodofone");
        billerRepository.save(biller);
    }
}
