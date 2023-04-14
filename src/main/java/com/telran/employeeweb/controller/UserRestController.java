package com.telran.employeeweb.controller;

import com.telran.employeeweb.model.entity.Employee;
import com.telran.employeeweb.model.entity.User;
import com.telran.employeeweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/usersRest")
public class UserRestController {

    private final UserService service;
    @Autowired
    public UserRestController(UserService service) {
        this.service = service;
    }
    @GetMapping
    public List<User> getUsers(){
        return service.getUser();
    }

    @GetMapping(value = "/findUser")
    public Optional<User> findEmployee(@RequestParam(required = false) String id,
                                           @RequestParam(required = false) String username){
        return service.findUserByIdAndName(id, username);
    }
    @PostMapping
    public User addEmployee(@RequestBody User user) {
        service.add(user);
        return user;
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        boolean isUpdated = service.updateUser(user);
        if (isUpdated){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUserSurnameAndRole(@PathVariable String id,
                                                         @RequestParam String username,
                                                         @RequestParam String role){
        User user = service.updateUserSurnameAndRole(id, username, role);
        if( user != null) {
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id){
        System.out.println("Deleting:" + id);
        service.deleteUser(id);
    }
}
