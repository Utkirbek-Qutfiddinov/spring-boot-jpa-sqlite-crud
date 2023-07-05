package com.example.jpaproject.controller;

import com.example.jpaproject.model.User;
import com.example.jpaproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String save(@RequestBody User user){
        userRepository.save(user);
        return "Successfully added!";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id){
        userRepository.deleteById(id);
        return "Succesfully deleted!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public String update(@RequestBody User user){
        Optional<User> optionalUser=userRepository.findById(user.getId());
        if (optionalUser.isPresent()){
            userRepository.save(user);
            return "Updated succesfully!";
        }else {
            return "User not found!";
        }
    }

}
