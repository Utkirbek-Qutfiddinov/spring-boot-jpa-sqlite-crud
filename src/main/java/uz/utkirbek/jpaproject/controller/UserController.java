package uz.utkirbek.jpaproject.controller;

import uz.utkirbek.jpaproject.dto.UserDto;
import uz.utkirbek.jpaproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.utkirbek.jpaproject.service.UserService;

import java.util.List;

/**
 * Author: utkirbek.
 * Time: 21:41:58
 * Date: July 04, 2023, Tuesday
 */
@RestController("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Integer id){
        return userService.getOne(id);
    }

    @PostMapping
    public String save(@RequestBody UserDto user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return userService.delete(id);

    }

    @PutMapping
    public String update(@RequestBody UserDto user){
        return userService.update(user);
    }

}
