package com.nasshb.pokerforge.pokeruser.controller;

import com.nasshb.pokerforge.pokeruser.dto.PokerUserRequest;
import com.nasshb.pokerforge.pokeruser.dto.PokerUserResponse;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.service.PokerUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokerUserController {

    private final PokerUserService userService;

    public PokerUserController(PokerUserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<PokerUserResponse> createUser(@RequestBody @Valid PokerUserRequest userRequest){
        PokerUser userCreated = userService.createUser(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getPassword(), userRequest.getEmail());
        PokerUserResponse userResponse = new PokerUserResponse(userCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<PokerUserResponse> getUserById(@PathVariable int userId){
        PokerUserResponse user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<PokerUserResponse>> getAllUsers(){
        List<PokerUserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
