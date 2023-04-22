package com.Sanket.User_services.External.Service;

import com.Sanket.User_services.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/Hotels/{hotelID}")
    Hotel getHotel(@PathVariable String hotelID);
}
