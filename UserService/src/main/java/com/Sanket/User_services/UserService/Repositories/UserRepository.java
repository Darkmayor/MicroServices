package com.Sanket.User_services.UserService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Sanket.User_services.UserService.entities.user;

public interface UserRepository
        extends JpaRepository<user,String> {

}
