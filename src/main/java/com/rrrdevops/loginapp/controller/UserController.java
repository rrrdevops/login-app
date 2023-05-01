package com.rrrdevops.loginapp.controller;

import com.rrrdevops.loginapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/"})
@Slf4j
public class UserController {
@Autowired
    UserService service;
    @GetMapping("")
    public String viewLoginPage(Model model) {
        return "login";
    }

    @PostMapping({"/save"})
    public String newposition(@ModelAttribute("username") String username,@ModelAttribute("password") String password) throws Exception {
        log.info("uname is " + username);
        log.info("password is " + password);
        this.service.getUser(username,password);
        return "redirect:/showuser";
    }

}
