package com.nasshb.pokerforge.pokeruser.repository;

import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokerUserRepository extends JpaRepository<PokerUser, Long> {

    Optional<PokerUser> findByEmail(String email);
}
