package com.nasshb.pokerforge.pokersession.service;

import com.nasshb.pokerforge.exception.PokerUserNotFoundException;
import com.nasshb.pokerforge.pokersession.dto.PokerSessionRequest;
import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.repository.PokerSessionRepository;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.repository.PokerUserRepository;
import org.springframework.stereotype.Service;

@Service
public class PokerSessionService {

    private final PokerSessionRepository sessionRepository;
    private final PokerUserRepository userRepository;

    public PokerSessionService(PokerSessionRepository sessionRepository, PokerUserRepository userRepository){
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    public PokerSession createSession(String name, Long buyIn, Long winnings, Integer userId){
        PokerUser user = userRepository.findById(userId)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        PokerSession session = new PokerSession(name, buyIn, winnings, user);
        return sessionRepository.save(session);
    }
}
