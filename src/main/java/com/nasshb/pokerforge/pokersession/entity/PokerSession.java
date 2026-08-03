package com.nasshb.pokerforge.pokersession.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PokerSession {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double buyIn;
    private double winnings;

    public PokerSession(){}

    public PokerSession(String name, double buyIn, double winnings){
        this.name = name;
        this.buyIn = buyIn;
        this.winnings = winnings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
