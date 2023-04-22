package com.Sanket.User_services.UserService.Exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(){
        super("Resource Not Found");
    }
    // if user passes a message then
    public ResourceNotFound(String message){
        super(message)  ;
    }



}
