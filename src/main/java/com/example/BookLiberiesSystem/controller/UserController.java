package com.example.BookLiberiesSystem.controller;

import com.example.BookLiberiesSystem.model.User;
import com.example.BookLiberiesSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getUserInfo")
    public List<User>getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public String updateUser(@RequestParam Integer id,@RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @GetMapping("/getUserByFirstName/{firstName}/{lastName}")
    public List<User>getByName(@RequestParam String firstName,@RequestParam String lastName) {
        return userService.getFirstName(firstName, lastName);
    }

    @GetMapping("/dataUsingPhoneNumber/{phoneNumber}")
    public List<User>getByNumber(@PathVariable String phoneNumber) {
        return userService.getByNumber(phoneNumber);
    }
}
