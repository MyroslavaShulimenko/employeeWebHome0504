package com.telran.employeeweb.controller;

import com.telran.employeeweb.model.entity.Employee;
import com.telran.employeeweb.model.entity.User;
import com.telran.employeeweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@SuppressWarnings("ALL")
@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model){
        List<User> users = service.getUser();
        model.addAttribute("users", users);
        return "users";
    }

}
