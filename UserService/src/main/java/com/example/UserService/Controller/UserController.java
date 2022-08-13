package com.example.UserService.Controller;


import com.example.UserService.Model.User;
import com.example.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
    @GetMapping("/users")
    public ResponseEntity<ArrayList<User>> getAllUsers(){
        return new ResponseEntity<ArrayList<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public void register(@RequestBody User newUser){
        userService.register(newUser);
    }
}
