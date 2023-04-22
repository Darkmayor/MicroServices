package com.Sanket.User_services.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class user {
    //setting properties
    @Id
    private String UID;
    private String Uname;
    private String email;
    private String About;
    private int Mobile_num;
   //The Transient property is used to make exceptions for storing datas.
    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
