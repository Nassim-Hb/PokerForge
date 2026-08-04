package com.nasshb.pokerforge.pokeruser.dto;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;

import java.util.List;

public class PokerUserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<PokerSession> sessions;

    public PokerUserResponse(PokerUser user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.sessions = user.getSessions();
    }

    public Long getId() {
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

    public List<PokerSession> getSessions() {
        return sessions;
    }
}
