package com.github.localstore.controller;

import com.github.localstore.dto.UserDto;
import com.github.localstore.model.UserModel;
import com.github.localstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/user/create")
    public UserDto createUser(@RequestBody UserModel userModel) throws NoSuchAlgorithmException {
        return userService.createUser(userModel);
    }

    @PostMapping(path = "/user/verify")
    public UserDto verifyUser(@RequestBody UserModel userModel) throws NoSuchAlgorithmException {
        return userService.verifyUser(userModel);
    }

}
