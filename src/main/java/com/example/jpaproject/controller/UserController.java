package com.example.jpaproject.controller;

import com.example.jpaproject.model.User;
import com.example.jpaproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: utkirbek.
 * Time: 21:41:58
 * Date: July 04, 2023, Tuesday
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
