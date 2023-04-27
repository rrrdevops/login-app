package com.rrrdevops.loginapp.controller;


import com.rrrdevops.loginapp.model.User;
import com.rrrdevops.loginapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {


  @Autowired
  UserService service;
  @GetMapping("/loginapp/users")
  List<User> getAllUsers()
  {
     return service.getALLUsers();
  }

  @GetMapping("/loginapp/users/{username}/{password}")
  User getUserDetails(@PathVariable("username") String username,@PathVariable("password") String password) throws Exception {
    return service.getUser(username,password);
  }

  @PostMapping("loginapp/users")
  public void saveUserDetails(@RequestBody User user)
  {
    service.saveUser(user);
  }

}
