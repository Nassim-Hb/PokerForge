package com.nasshb.pokerforge.pokersession.controller;

import com.nasshb.pokerforge.pokersession.dto.PokerSessionRequest;
import com.nasshb.pokerforge.pokersession.dto.PokerSessionResponse;
import com.nasshb.pokerforge.pokersession.dto.PokerSessionUpdateRequest;
import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.service.PokerSessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/sessions/{id}")
    public ResponseEntity<PokerSessionResponse> getSessionById(@PathVariable Integer id){
        PokerSessionResponse session = sessionService.getSessionById(id);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<PokerSessionResponse>> getAllSessions(){
        List<PokerSessionResponse> sessions = sessionService.getAllSessions();
        return ResponseEntity.ok(sessions);
    }

    @PutMapping("/sessions/{id}")
    public ResponseEntity<PokerSessionResponse> modifySession(@PathVariable Integer id, @RequestBody @Valid PokerSessionUpdateRequest sessionRequest){
        PokerSessionResponse session = sessionService.modifySession(id, sessionRequest.getSessionName(), sessionRequest.getBuyIn(), sessionRequest.getWinnings());
        return ResponseEntity.ok(session);
    }

    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<PokerSessionResponse> deleteSession(@PathVariable Integer id){
        sessionService.deleteSession(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
