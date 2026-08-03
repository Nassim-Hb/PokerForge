package com.nasshb.pokerforge.pokersession.service;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.repository.PokerSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class PokerSessionService {

    private final PokerSessionRepository sessionRepository;

    public PokerSessionService(PokerSessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public PokerSession createSession(String name, double buyIn, double winnings){
        PokerSession session = new PokerSession(name, buyIn, winnings);
        return sessionRepository.save(session);
    }
}
