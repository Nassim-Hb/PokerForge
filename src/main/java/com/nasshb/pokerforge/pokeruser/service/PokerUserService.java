package com.nasshb.pokerforge.pokeruser.service;

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

    public PokerUserService(PokerUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public PokerUser createUser(String firstName, String lastName, String password, String email){
        PokerUser user = new PokerUser(firstName, lastName, password, email);
        return userRepository.save(user);
    }

    public PokerUserResponse getUserById(Integer id){
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

    public PokerUserResponse modifyUser(Integer id, String firstName, String lastName){
        PokerUser user = userRepository.findById(id)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
        return new PokerUserResponse(user);
    }

    public void deleteUser(Integer id){
        PokerUser user = userRepository.findById(id)
                .orElseThrow(() -> new PokerUserNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
