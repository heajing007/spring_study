package com.test.controller;

import com.test.common.AutoWired;
import com.test.service.UserService;

public class UserController {

    @AutoWired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
