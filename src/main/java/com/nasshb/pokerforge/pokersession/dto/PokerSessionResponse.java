package com.nasshb.pokerforge.pokersession.dto;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokeruser.dto.PokerUserSummary;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;

public class PokerSessionResponse {
    private Long id;
    private String sessionName;
    private double buyIn;
    private double winnings;
    private PokerUserSummary user;

    public PokerSessionResponse(PokerSession session){
        this.id = session.getId();
        this.sessionName = session.getSessionName();
        this.buyIn = session.getBuyIn();
        this.winnings = session.getWinnings();
        this.user = new PokerUserSummary(session.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
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

    public PokerUserSummary getUser() {
        return user;
    }

    public void setUser(PokerUserSummary user) {
        this.user = user;
    }
}
