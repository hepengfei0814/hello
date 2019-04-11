package com.hpf.hello.repository.repositoryImpl;

import com.hpf.hello.entity.User;
import com.hpf.hello.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userRepository.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        System.out.println("查找用户：-------------------------");
        User user= userRepository.findUserByUserName("小明");
        System.out.println("user is "+user);
    }

}