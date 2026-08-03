package com.nasshb.pokerforge.pokeruser.controller;

import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.service.PokerUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerUserController {

    private final PokerUserService userService;

    public PokerUserController(PokerUserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<PokerUser> createUser(@RequestBody PokerUser pokerUser){
        PokerUser userCreated = userService.createUser(pokerUser.getFirstName(), pokerUser.getLastName(), pokerUser.getPassword(), pokerUser.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
