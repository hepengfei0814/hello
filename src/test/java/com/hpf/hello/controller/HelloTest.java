package com.hpf.hello.controller;

import com.hpf.hello.entity.Student;
import com.hpf.hello.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private StudentRepository studentRepository;

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

    @Test
    public void getUid() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/uid"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findAllStudent() throws Exception{
        int page = 2,size = 5;
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Student> students = studentRepository.findAll(pageable);
        for(Student student:students){
            System.out.println(student.toString());
        }
    }

    @Test
    public void findStudentByAge() throws Exception{
        Integer age = 22,page = 0,size = 5;
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Student> students = studentRepository.findByAge(age,pageable);
        for (Student student:students){
            System.out.println(student.toString());
        }
    }
}