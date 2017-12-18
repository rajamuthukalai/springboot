package com.billtracker.repository;


import com.billtracker.model.Biller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

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
       // biller.setId(1L);
        biller.setServiceProvider("vodofone");

        entityManager.persist(biller);
        entityManager.flush();

        // when
        List<Biller> found = billerRepository.findAll();

        // then
        assertThat(found.get(0).getServiceProvider())
                .isEqualTo(biller.getServiceProvider());
    }
}
