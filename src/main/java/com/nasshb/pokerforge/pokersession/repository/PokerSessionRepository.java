package com.nasshb.pokerforge.pokersession.repository;

import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokerSessionRepository extends JpaRepository<PokerSession, Long> {

    List<PokerSession> findAllByUserId(Long userId);
}
