package com.hpf.hello.controller;

import com.hpf.hello.entity.Student;
import com.hpf.hello.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class Hello {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){

        return "Hello Springboot";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void addStudent(String name,Integer age){
        Student s=new Student();
        s.setName(name);
        s.setAge(age);
        studentRepository.save(s);
    }

    @RequestMapping("/getStudent")
    @Cacheable(value = "student-key")
    public Student getStudent(){
        Student s=new Student();
        s.setName("lisi");
        s.setAge(21);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return s;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }

}
