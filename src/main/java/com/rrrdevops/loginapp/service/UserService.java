package com.rrrdevops.loginapp.service;

import com.rrrdevops.loginapp.exception.UserNotFoundException;
import com.rrrdevops.loginapp.model.User;
import com.rrrdevops.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    public List<User> getALLUsers()
    {
       return repository.findAll();
    }

    public Optional<User> getUser(String uname )
    {
        return repository.findById(uname);
    }
    public User getUser(String uname,String password) throws Exception {
        String id= repository.findUserbyCreds(uname,password);
        if(id==null)
        {
            throw new UserNotFoundException("Authentication not Successful");
        }
        User userDetails=repository.getById(id);
        return userDetails;
    }

    public void  saveUser(User user)
    {
     repository.save(user);
    }

}
