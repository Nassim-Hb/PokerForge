package com.nasshb.pokerforge.pokeruser.service;

import com.nasshb.pokerforge.pokersession.dto.PokerSessionResponse;
import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.repository.PokerSessionRepository;
import com.nasshb.pokerforge.pokeruser.dto.PokerUserResponse;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.exception.PokerUserNotFoundException;
import com.nasshb.pokerforge.pokeruser.repository.PokerUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokerUserService {

    private final PokerUserRepository userRepository;
    private final PokerSessionRepository sessionRepository;

    public PokerUserService(PokerUserRepository userRepository, PokerSessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public PokerUserResponse createUser(String firstName, String lastName, String password, String email){
        PokerUser user = new PokerUser(firstName, lastName, password, email);
        userRepository.save(user);
        return new PokerUserResponse(user);
    }

    public PokerUserResponse getUserById(Long id){
        PokerUser user = userRepository.findById(id)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        return new PokerUserResponse(user);
    }

    public List<PokerUserResponse> getAllUsers(){
        List<PokerUser> userList = userRepository.findAll();
        List<PokerUserResponse> responseUserList = new ArrayList<>();

        for(PokerUser user : userList){
            responseUserList.add(new PokerUserResponse(user));
        }
        return responseUserList;
    }

    public PokerUserResponse modifyUser(Long id, String firstName, String lastName){
        PokerUser user = userRepository.findById(id)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
        return new PokerUserResponse(user);
    }

    public void deleteUser(Long id){
        PokerUser user = userRepository.findById(id)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        userRepository.delete(user);
    }

    public List<PokerSessionResponse> getAllSessionsFromASpecificUser(Long userId){
        userRepository.findById(userId)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        List<PokerSession> sessionList = sessionRepository.findAllByUserId(userId);
        List<PokerSessionResponse> sessionResponseList = new ArrayList<>();

        for(PokerSession session : sessionList){
            sessionResponseList.add(new PokerSessionResponse(session));
        }
        return sessionResponseList;
    }
}
