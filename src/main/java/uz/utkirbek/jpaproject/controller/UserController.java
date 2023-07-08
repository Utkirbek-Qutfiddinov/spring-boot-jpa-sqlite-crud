package uz.utkirbek.jpaproject.controller;

import uz.utkirbek.jpaproject.model.User;
import uz.utkirbek.jpaproject.repository.UserRepository;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    @PostMapping
    public String save(@RequestBody User user){
        userRepository.save(user);
        return "Successfully added!";
    }

    @DeleteMapping
    public String delete(@PathVariable Integer id){
        userRepository.deleteById(id);
        return "Succesfully deleted!";
    }

    @PutMapping
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
