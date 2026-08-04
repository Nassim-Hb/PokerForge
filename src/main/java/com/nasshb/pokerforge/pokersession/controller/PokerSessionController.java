package com.nasshb.pokerforge.pokersession.controller;

import com.nasshb.pokerforge.pokersession.dto.PokerSessionRequest;
import com.nasshb.pokerforge.pokersession.dto.PokerSessionResponse;
import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.service.PokerSessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerSessionController {
    private final PokerSessionService sessionService;

    public PokerSessionController (PokerSessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping("/sessions")
    public ResponseEntity<PokerSessionResponse> createSession(@RequestBody @Valid PokerSessionRequest sessionRequest){
        PokerSession sessionCreated = sessionService.createSession(sessionRequest.getSessionName(), sessionRequest.getBuyIn(), sessionRequest.getWinnings(), sessionRequest.getUserId());
        PokerSessionResponse sessionResponse = new PokerSessionResponse(sessionCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionResponse);
    }
}
