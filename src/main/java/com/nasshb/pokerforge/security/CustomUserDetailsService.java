package com.nasshb.pokerforge.security;

import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.repository.PokerUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PokerUserRepository userRepository;

    public CustomUserDetailsService (PokerUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PokerUser user = userRepository.findByEmail(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new PokerUserDetails(user);
    }
}
