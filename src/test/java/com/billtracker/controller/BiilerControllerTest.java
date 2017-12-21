package com.billtracker.controller;


import com.billtracker.model.Biller;
import com.billtracker.repository.BiilerRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BillerController.class)
public class BiilerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BiilerRepository repository;

    @Before
    public void setUp() {
        Biller biller = new Biller();
        biller.setId(1L);
        biller.setName("vodofone");

        List<Biller> allBillers = Arrays.asList(biller);

        given(repository.findAll()).willReturn(allBillers);

        given(repository.findOne(1L)).willReturn(biller);
    }


    @Test
    public void testGetAllBillers()
            throws Exception {

        mvc.perform(get("/api/billers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("vodofone")));
    }

    @Test
    public void testGetBiller()
            throws Exception {

        mvc.perform(get("/api/biller/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.name", is("vodofone")));
    }
}
