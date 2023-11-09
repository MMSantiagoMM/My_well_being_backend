package com.mywellbeing.psychology.exceptions;

public class PsychologyNotFoundException extends RuntimeException{

    public PsychologyNotFoundException(Long id){
        super("Psychology category with the id: " + id + " was not found");
    }
}
