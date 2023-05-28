package com.github.localstore.service;

import com.github.localstore.dao.UserDao;
import com.github.localstore.dto.UserDto;
import com.github.localstore.model.UserModel;
import com.github.localstore.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.github.localstore.utils.enums.UserStatusEnum.*;
import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserMapper userMapper;


    private static String bytesToHex(byte[] hashbytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hashbytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    @Override
    public UserDto createUser(UserModel userModel) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        final byte[] hashbytes = digest.digest(userModel.getPassword().getBytes(UTF_8));
        String sha3Hex = bytesToHex(hashbytes);
        userModel.setPassword(sha3Hex);
        userModel = userDao.save(userModel);
        UserDto userDto = userMapper.INSTANCE.toUserDto(userModel);
        userDto.setStatus(CREATED);
        return userDto;
    }

    public UserDto verifyUser(UserModel userModel) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        final byte[] hashbytes = digest.digest(userModel.getPassword().getBytes(UTF_8));
        String sha3Hex = bytesToHex(hashbytes);
        UserModel savedUser = userDao.findByUsername(userModel.getUsername());
        UserDto userDto = userMapper.INSTANCE.toUserDto(userModel);
        if (savedUser.getPassword().equals(sha3Hex)) {
            userDto.setStatus(VERIFIED);
        } else {
            userDto.setStatus(NOT_VERIFIED);
        }
        return userDto;
    }

}
