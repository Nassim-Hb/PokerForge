package com.nasshb.pokerforge.pokersession.entity;

import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PokerSession {

    @Id
    @GeneratedValue
    private Long id;
    private String sessionName;
    private double buyIn;
    private double winnings;
    @ManyToOne
    private PokerUser user;

    public PokerSession(){}

    public PokerSession(String name, double buyIn, double winnings, PokerUser user){
        this.sessionName = name;
        this.buyIn = buyIn;
        this.winnings = winnings;
        this.user = user;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String name) {
        this.sessionName = name;
    }

    public double getBuyIn() {
        return buyIn;
    }

    public void setBuyIn(double buyIn) {
        this.buyIn = buyIn;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PokerUser getUser() {
        return user;
    }

    public void setUser(PokerUser user) {
        this.user = user;
    }
}
