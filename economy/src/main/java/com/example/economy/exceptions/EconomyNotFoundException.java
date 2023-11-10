package com.example.economy.exceptions;

public class EconomyNotFoundException extends RuntimeException{

    public EconomyNotFoundException(Long id){
        super("Economy category with the id: " + id + " was not found");
    }
}
