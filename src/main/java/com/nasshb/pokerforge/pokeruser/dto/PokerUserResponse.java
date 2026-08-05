package com.nasshb.pokerforge.pokeruser.dto;

import com.nasshb.pokerforge.pokersession.dto.PokerSessionSummary;
import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;

import java.util.List;

public class PokerUserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<PokerSessionSummary> sessions;

    public PokerUserResponse(PokerUser user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.sessions = user.getSessions()
                .stream()
                .map(PokerSessionSummary::new)
                .toList();
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

    public List<PokerSessionSummary> getSessions() {
        return sessions;
    }
}
