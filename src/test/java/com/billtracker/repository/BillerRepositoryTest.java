package com.billtracker.repository;


import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.billtracker.model.Biller;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BillerRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BiilerRepository billerRepository;


    @Test
    public void testBiilerInsert() {    	
        // given
        Biller biller = new Biller();
        biller.setName("Test Biller");

        entityManager.persist(biller);
        entityManager.flush();

        // when
        List<Biller> found = billerRepository.findAll();

        // then
        assertThat(found.contains(biller));
    }
}