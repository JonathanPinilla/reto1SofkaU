package com.sofka.reto1.exception.general;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}