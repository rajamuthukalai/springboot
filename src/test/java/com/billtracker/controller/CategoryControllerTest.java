package com.billtracker.controller;

import com.billtracker.model.Biller;
import com.billtracker.model.Category;
import com.billtracker.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryRepository repository;



    @Before
    public void setUp() {
        Category category = new Category();
        category.setId(1L);
        category.setName("mobile");

        List<Category> categories = Arrays.asList(category);

        given(repository.findAll()).willReturn(categories);

        given(repository.findOne(1L)).willReturn(category);
    }


    @Test
    public void testGetAllCategories()
            throws Exception {

        mvc.perform(get("/api/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("mobile")));
    }

    @Test
    public void testGetBiller()
            throws Exception {

        mvc.perform(get("/api/category/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.name", is("mobile")));
    }
}
