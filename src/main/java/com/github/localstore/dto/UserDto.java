package com.github.localstore.dto;

import com.github.localstore.utils.enums.UserStatusEnum;

public class UserDto {
    private String username;

    private UserStatusEnum status;

    public UserDto(String username, UserStatusEnum status) {
        this.username = username;
        this.status = status;
    }

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }
}
