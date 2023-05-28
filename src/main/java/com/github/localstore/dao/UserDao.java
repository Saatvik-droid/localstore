package com.github.localstore.dao;

import com.github.localstore.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
