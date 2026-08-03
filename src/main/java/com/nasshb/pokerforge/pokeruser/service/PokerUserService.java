package com.nasshb.pokerforge.pokeruser.service;

import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.repository.PokerUserRepository;
import org.springframework.stereotype.Service;

@Service
public class PokerUserService {

    private final PokerUserRepository userRepository;

    public PokerUserService(PokerUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public PokerUser createUser(String firstName, String lastName, String password, String email){
        PokerUser user = new PokerUser(firstName, lastName, password, email);
        return userRepository.save(user);
    }
}
