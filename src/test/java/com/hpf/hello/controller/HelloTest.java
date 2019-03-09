package com.hpf.hello.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void helloTest() throws  Exception{
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assert(mvcResult.getResponse().getStatus() == 200);
    }

    @Test
    public void addTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/add"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getStudentTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/getStudent"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}