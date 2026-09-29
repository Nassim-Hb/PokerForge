package com.nasshb.pokerforge.pokeruser.controller;

import com.nasshb.pokerforge.pokersession.dto.PokerSessionResponse;
import com.nasshb.pokerforge.pokeruser.dto.PokerUserRequest;
import com.nasshb.pokerforge.pokeruser.dto.PokerUserResponse;
import com.nasshb.pokerforge.pokeruser.dto.PokerUserUpdateRequest;
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
        PokerUserResponse userCreated = userService.createUser(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getPassword(), userRequest.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<PokerUserResponse> getUserById(@PathVariable Long userId){
        PokerUserResponse user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<PokerUserResponse>> getAllUsers(){
        List<PokerUserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<PokerUserResponse> modifyUser(@PathVariable Long id, @RequestBody @Valid PokerUserUpdateRequest userRequest){
        PokerUserResponse user = userService.modifyUser(id, userRequest.getFirstName(), userRequest.getLastName());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<PokerUserResponse> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/users/{userId}/sessions")
    public ResponseEntity<List<PokerSessionResponse>> getAllSessionsFromASpecificUser(@PathVariable Long userId){
        List<PokerSessionResponse> userSessions = userService.getAllSessionsFromASpecificUser(userId);
        return ResponseEntity.ok(userSessions);
    }
}
