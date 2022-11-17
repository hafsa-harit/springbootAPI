package com.javatechie.student;

import com.javatechie.student.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")// for navigate to " localhost:8072/api/v1/user "
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService)
    {this.userService=userService;}

    @GetMapping
    public List<User> getUser()
    {
        return userService.getUser();
    }


    @PostMapping
    public  void saveUser(@RequestBody User user)
    {
        userService.addNewUser(user);
    }
}
