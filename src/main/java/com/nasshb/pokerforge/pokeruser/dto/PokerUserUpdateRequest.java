package com.nasshb.pokerforge.pokeruser.dto;

import jakarta.validation.constraints.NotEmpty;

public class PokerUserUpdateRequest {

    @NotEmpty(message = "Enter a valid first name")
    private String firstName;
    @NotEmpty(message = "Enter a valid last name")
    private String lastName;

    public PokerUserUpdateRequest(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
