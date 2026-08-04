package com.nasshb.pokerforge.pokeruser.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PokerUserRequest {
    @NotEmpty(message = "The first name must not be empty")
    private String firstName;
    @NotEmpty(message = "The last name must not be empty")
    private String lastName;
    @NotEmpty(message = "The password must not be empty")
    private String password;
    @Email(message = "Enter a valid email")
    private String email;

    public PokerUserRequest(){}

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
