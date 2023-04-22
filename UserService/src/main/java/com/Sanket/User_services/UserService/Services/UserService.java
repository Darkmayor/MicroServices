package com.Sanket.User_services.UserService.Services;

import com.Sanket.User_services.UserService.entities.user;

import java.util.List;

public interface UserService {
    //user Operations

    //create User
    user SaveUser(user user);
    //get all USers
    List<user> GetAllUsers();
    // get specific user
    user GetUser(String UID);
}
