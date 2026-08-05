package com.nasshb.pokerforge.pokeruser.dto;

import com.nasshb.pokerforge.pokeruser.entity.PokerUser;

public class PokerUserSummary {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public PokerUserSummary(PokerUser user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
