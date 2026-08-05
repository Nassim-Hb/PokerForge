package com.nasshb.pokerforge.pokersession.dto;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;

public class PokerSessionSummary {
    private Long id;
    private String sessionName;
    private double buyIn;
    private double winnings;

    public PokerSessionSummary(PokerSession session){
        this.id = session.getId();
        this.sessionName = session.getSessionName();
        this.buyIn = session.getBuyIn();
        this.winnings = session.getWinnings();
    }

    public Long getId() {
        return id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public double getBuyIn() {
        return buyIn;
    }

    public double getWinnings() {
        return winnings;
    }
}
