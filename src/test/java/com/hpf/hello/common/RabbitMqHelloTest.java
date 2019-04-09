package com.hpf.hello.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception{
        helloSender.send();
    }

    @Test
    public void topicTest() throws Exception{
        helloSender.send1();
        helloSender.send2();
    }

    @Test
    public void fanoutTest()throws Exception{
        helloSender.fanoutSend();
    }
}