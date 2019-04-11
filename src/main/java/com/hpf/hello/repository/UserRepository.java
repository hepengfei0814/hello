package com.hpf.hello.repository;

import com.hpf.hello.entity.User;

public interface UserRepository {

    public void saveUser(User user);

    public User findUserByUserName(String userName);
}
