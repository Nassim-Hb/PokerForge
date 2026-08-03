package com.nasshb.pokerforge.pokersession.controller;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.service.PokerSessionService;
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
    public ResponseEntity<PokerSession> createSession(@RequestBody PokerSession session){
        PokerSession sessionCreated = sessionService.createSession(session.getName(), session.getBuyIn(), session.getWinnings());
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionCreated);
    }
}
