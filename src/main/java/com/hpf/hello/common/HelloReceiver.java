package com.hpf.hello.common;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {

    @RabbitListener(queues = "hello")
    public void process(String hello){
        System.out.println("Receiver  : " + hello);
    }

    @RabbitListener(queues = "topic.message")
    public void processTopic(String context){
        System.out.println("Topic:" +  context);
    }

    @RabbitListener(queues = "topic.messages")
    public void processTopic2(String context){
        System.out.println("Topic2:" +  context);
    }

    @RabbitListener(queues = "fanout.A")
    public void processFanoutA(String context){
        System.out.println("fanout.A.Receiver:" +  context);
    }

    @RabbitListener(queues = "fanout.B")
    public void processFanoutB(String context){
        System.out.println("fanout.B.Receiver:" +  context);
    }

    @RabbitListener(queues = "fanout.C")
    public void processFanoutC(String context){
        System.out.println("fanout.C.Receiver:" +  context);
    }
}
