package com.Sanket.User_services.Controller;

import com.Sanket.User_services.UserService.Services.UserService;
import com.Sanket.User_services.UserService.entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.rmi.server.UID;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //create user
    @PostMapping
    public ResponseEntity<user> CreateUser(@RequestBody user user){
    user user1 = userService.SaveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //Get Single User
    @GetMapping("/{UID}")
    public ResponseEntity<user> GetUser(@PathVariable String UID) {
       user user = userService.GetUser(UID);
       return ResponseEntity.ok(user);
    }
    //Get All Users
    @GetMapping
    public ResponseEntity<List<user>> GetAllUser(){
       List<user> allUser = userService.GetAllUsers();
       return ResponseEntity.ok(allUser);
    }
}
