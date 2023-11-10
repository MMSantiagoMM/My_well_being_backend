package com.example.education.exceptions;

public class EducationNotFoundException extends RuntimeException{

    public EducationNotFoundException(Long id){
        super("Psychology category with the id: " + id + " was not found");
    }
}
