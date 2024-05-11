package com.example.HotelMangement.Exception;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends RuntimeException {

    public CustomException(String s) {
        super(s);
    }

    public CustomException() {
        super("Resource Not Found");
    }
}
