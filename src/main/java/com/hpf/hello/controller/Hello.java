package com.hpf.hello.controller;

import com.hpf.hello.entity.Student;
import com.hpf.hello.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){

        return "Hello Springboot";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void addStudent(){
        Student s=new Student();
        s.setName("zhangsan");
        s.setAge("23");
        studentRepository.save(s);
    }

    @RequestMapping("/getStudent")
    public Student getStudent(){
        Student s=new Student();
        s.setName("lisi");
        s.setAge("21");
        System.out.println(s.getName());
        return s;
    }
}
