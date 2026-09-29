package com.nasshb.pokerforge.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authManager;

    public AuthenticationService (AuthenticationManager authManager){
        this.authManager = authManager;
    }

}
