package com.nasshb.pokerforge.pokersession.repository;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokerSessionRepository extends JpaRepository<PokerSession, Integer> {

}
