package com.telran.employeeweb.service;

import com.telran.employeeweb.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUser();

    Optional<User> findUserByIdAndName(String id, String name);

    void add(User user);

    boolean updateUser(User user);

    User updateUserSurnameAndRole(String id, String surname, String role);

    void deleteUser(String id);
}
