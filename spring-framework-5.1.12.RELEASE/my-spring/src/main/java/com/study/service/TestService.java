package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestService {

    @Autowired
    private UserService userService;

    public TestService() {
        System.out.println("test init");
    }

    //spring生命周期的初始化回调方法
    @PostConstruct
    public void aa(){
        System.out.println("spring生命周期的初始化回调方法!!!!!");
    }
}
