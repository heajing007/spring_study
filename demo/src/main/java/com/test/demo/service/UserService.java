package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private TestService testService;

    public UserService() {
        System.out.println("user init");
    }
}
