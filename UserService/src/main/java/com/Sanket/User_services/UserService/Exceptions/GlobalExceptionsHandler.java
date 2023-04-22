package com.Sanket.User_services.UserService.Exceptions;

import com.Sanket.User_services.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionsHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> HandlerResourceNotFound(ResourceNotFound Excp){
    String messgae = Excp.getMessage();
    ApiResponse response = ApiResponse.builder().message(messgae).success(true).Status(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }

}
