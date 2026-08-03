package com.nasshb.pokerforge.pokeruser.repository;

import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokerUserRepository extends JpaRepository<PokerUser, Integer> {
}
