package com.telran.employeeweb.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private String id;
    private String username;
   private String password;
    private String role;
    private String email;

    public User(String id, String username, String password, String role, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

//    public String getId() {
//        return id;
//    }

    public User() {
    }
}
