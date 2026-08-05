package com.nasshb.pokerforge.pokersession.dto;

import jakarta.validation.constraints.*;

public class PokerSessionUpdateRequest {

    @NotEmpty(message = "Enter a valid session name")
    private String sessionName;
    @NotNull
    @PositiveOrZero
    private Long buyIn;
    @NotNull
    @PositiveOrZero
    private Long winnings;

    public PokerSessionUpdateRequest(){}

    public String getSessionName() {
        return sessionName;
    }

    public Long getBuyIn() {
        return buyIn;
    }

    public Long getWinnings() {
        return winnings;
    }
}
