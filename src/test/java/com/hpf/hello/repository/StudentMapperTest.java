package com.hpf.hello.repository;

import com.hpf.hello.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testQuery(){
        List<Student> list = studentMapper.getAll();
        System.out.println(list.toString());
    }

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setName("li5");
        student.setAge(23);
        studentMapper.insert(student);
    }

}