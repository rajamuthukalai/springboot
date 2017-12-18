package com.billtracker.repository;


import com.billtracker.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository repository;

    @Test
    public void testCategoryInser()
    {
        Category category = new Category();

        category.setName("mobile");

        entityManager.persist(category);
        entityManager.flush();

        List<Category> list = repository.findAll();

        assertThat(list.get(0).getName().equals(category.getName()));

    }
}
