package com.nasshb.pokerforge.pokersession.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PokerSessionRequest {
    @NotEmpty(message = "the session name should not be empty")
    private String sessionName;
    @NotNull
    @PositiveOrZero
    private Long buyIn;
    @NotNull
    @PositiveOrZero
    private Long winnings;
    @NotNull
    @PositiveOrZero
    private Integer userId;

    public PokerSessionRequest(){}

    public String getSessionName() {
        return sessionName;
    }

    public Long getBuyIn() {
        return buyIn;
    }

    public Long getWinnings() {
        return winnings;
    }

    public Integer getUserId() {
        return userId;
    }
}
