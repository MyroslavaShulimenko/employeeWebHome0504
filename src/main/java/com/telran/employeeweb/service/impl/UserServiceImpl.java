package com.telran.employeeweb.service.impl;

import com.telran.employeeweb.model.entity.User;
import com.telran.employeeweb.repository.UserRepository;
import com.telran.employeeweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUser() {
        return repository.getAll();
    }

    @Override
    public Optional<User> findUserByIdAndName(String id, String name) {
        List<User> users = repository.getAll();
       Optional<User>found= users.stream().filter(user -> {
            if (id != null) {
                if (name != null) {
                    return user.getId().equals(id) && user.getUsername().equals(name);
                } else {
                    return user.getId().equals(id);
                }
            }
            return user.getUsername().equals(name);

        }).findAny();
        return found;
    }
// @Override
//    public Optional<Employee> findEmployeeByIdAndName(String id, String name) {
//        List<Employee> employees = repository.getAll();
//        Optional<Employee> found = employees.stream().filter(employee -> {
//            if (id != null) {
//                if (name != null) {
//                    return employee.getId().equals(id) && employee.getName().equals(name);
//                } else {
//                    return employee.getId().equals(id);
//                }
//            }
//            return employee.getName().equals(name);
//        }).findAny();
//        return found;
//    }
    @Override
    public void add(User user) {
        repository.add(user);
    }

    @Override
    public boolean updateUser(User user) {

        List<User> users = repository.getAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())){
                repository.updateById(user);
                return true;
            }
        }
        repository.add(user);
        return false;
    }

    @Override
    public User updateUserSurnameAndRole(String id, String username, String role) {
        User user = repository.getById(id);
        if (user != null) {
            user.setUsername(username);
            user.setRole(role);
        }
        return user;
    }

    @Override
    public void deleteUser(String id) {
        repository.deleteUser(id);
    }
}
