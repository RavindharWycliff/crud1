package com.example.demo;

public class TeamResponseEntity {
 
    private String errorMessage;
 
    public TeamResponseEntity(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
}