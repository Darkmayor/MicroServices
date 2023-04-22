package com.Sanket.User_services.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String RatingID;
    private String UID;
    private String HotelID;
    private int Rating;
    private String Feedback;
    private Hotel hotel;
}
