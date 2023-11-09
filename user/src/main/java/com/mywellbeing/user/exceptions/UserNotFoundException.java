package com.mywellbeing.user.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("User with the id: " + id + " was not found");
    }
}
