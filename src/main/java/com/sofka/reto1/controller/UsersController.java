package com.sofka.reto1.controller;

import com.sofka.reto1.domain.Users;
import com.sofka.reto1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(path = "")
    public List<Users> getUsers(){
        return usersService.findAll();
    }

    @PostMapping(path = "")
    public Users newUser(@RequestBody Users user) throws IllegalArgumentException {
        user.setState(1);
        if(usersService.findByEmail(user.getEmail()).isEmpty()){
            return usersService.createUser(user);
        }else{
            throw new IllegalArgumentException("Email already exists");
        }

    }

    @PutMapping (path = "")
    public Users updateUser(@RequestBody Users user){
        return usersService.createUser(user);
    }
}
