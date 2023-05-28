package com.github.localstore.service;

import com.github.localstore.dto.UserDto;
import com.github.localstore.model.UserModel;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    UserDto createUser(UserModel userModel) throws NoSuchAlgorithmException;

    UserDto verifyUser(UserModel userModel) throws NoSuchAlgorithmException;
}
