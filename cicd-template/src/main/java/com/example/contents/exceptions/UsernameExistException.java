package com.example.contents.exceptions;

public class UsernameExistException extends Status400Exception {
    public UsernameExistException() {
        super("username not unique");
    }
}
