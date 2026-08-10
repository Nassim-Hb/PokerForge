package com.nasshb.pokerforge.pokersession.service;

import com.nasshb.pokerforge.exception.PokerSessionNotFoundException;
import com.nasshb.pokerforge.exception.PokerUserNotFoundException;
import com.nasshb.pokerforge.pokersession.dto.PokerSessionRequest;
import com.nasshb.pokerforge.pokersession.dto.PokerSessionResponse;
import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.repository.PokerSessionRepository;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.repository.PokerUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokerSessionService {

    private final PokerSessionRepository sessionRepository;
    private final PokerUserRepository userRepository;

    public PokerSessionService(PokerSessionRepository sessionRepository, PokerUserRepository userRepository){
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    public PokerSessionResponse createSession(String name, Long buyIn, Long winnings, Integer userId){
        PokerUser user = userRepository.findById(userId)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        PokerSession session = new PokerSession(name, buyIn, winnings, user);
        sessionRepository.save(session);
        return new PokerSessionResponse(session);
    }

    public PokerSessionResponse getSessionById(Integer sessionId){
        PokerSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new PokerSessionNotFoundException("Session not found"));
        return new PokerSessionResponse(session);
    }

    public List<PokerSessionResponse> getAllSessions(){
        List<PokerSession> sessions = sessionRepository.findAll();
        List<PokerSessionResponse> sessionsResponse = new ArrayList<>();

        for(PokerSession session : sessions){
            sessionsResponse.add(new PokerSessionResponse(session));
        }
        return sessionsResponse;
    }

    public PokerSessionResponse modifySession(Integer id, String sessionName, Long buyIn, Long winnings){
        PokerSession session = sessionRepository.findById(id)
                .orElseThrow(() -> new PokerSessionNotFoundException("Session not found"));
        session.setSessionName(sessionName);
        session.setBuyIn(buyIn);
        session.setWinnings(winnings);
        sessionRepository.save(session);
        return new PokerSessionResponse(session);
    }

    public void deleteSession(Integer id){
        PokerSession session = sessionRepository.findById(id)
                .orElseThrow(() -> new PokerSessionNotFoundException("Session not found"));
        sessionRepository.delete(session);
    }
}
