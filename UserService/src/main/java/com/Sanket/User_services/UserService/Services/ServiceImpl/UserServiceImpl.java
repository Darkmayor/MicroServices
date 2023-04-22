package com.Sanket.User_services.UserService.Services.ServiceImpl;

import com.Sanket.User_services.External.Service.HotelService;
import com.Sanket.User_services.UserService.Exceptions.ResourceNotFound;
import com.Sanket.User_services.UserService.Repositories.UserRepository;
import com.Sanket.User_services.UserService.Services.UserService;
import com.Sanket.User_services.UserService.entities.Hotel;
import com.Sanket.User_services.UserService.entities.Rating;
import com.Sanket.User_services.UserService.entities.user;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    //Create USer
    @Override
    public user SaveUser(user user) {
        //Generate usique id
        String Ruid = UUID.randomUUID().toString();
        user.setUID(Ruid);
        return userRepository.save(user);
    }
    //Get All Users
    @Override
    public List<user> GetAllUsers() {
        return userRepository.findAll();
    }
    //Get SIngle User
    @Override
    public user GetUser(String UID) {
       //Return Single USer
        //Creating a user object and checking if there is any user found in the db
        //if not found then throwing exception
        user user = userRepository.findById(UID).orElseThrow(()-> new ResourceNotFound("The User is not present on the server ::"+UID));
        //Fetch data From Rating Service and Implement it.
        //http://localhost:8083/ratings/users/7c79ed7c-ebf9-419d-8d46-c7dea8eeda40
        //Above is hardcoded url
        //creating a array of rating class and storing the user id in that array

       // Using RestTemplate
         Rating[] RatingsOfUSer = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUID(), Rating[].class);
        logger.info("{} ",RatingsOfUSer);
        //converting array to a list.
        List<Rating> ratingList1 = Arrays.stream(RatingsOfUSer).toList();
        //Setting Specific hotel id with user id
        List<Rating> ratingList = ratingList1.stream().map(rating -> {
            //Api call to hotel service for hotel id
            //Harcoded url for hotel id = http://localhost:8082/Hotels/48f1c4d4-b990-4988-be19-f9b21324006b
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/Hotels/" + rating.getHotelID(), Hotel.class);
//            Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelID());
           // logger.info("Response Code: {}",forEntity.getStatusCode());

            //set hotelid to rating
            rating.setHotel(hotel);
            // return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList1);
        return user;

    }



}
