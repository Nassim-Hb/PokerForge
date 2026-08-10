package com.nasshb.pokerforge;

import com.nasshb.pokerforge.exception.PokerSessionNotFoundException;
import com.nasshb.pokerforge.exception.PokerUserNotFoundException;
import com.nasshb.pokerforge.pokersession.dto.PokerSessionResponse;
import com.nasshb.pokerforge.pokersession.entity.PokerSession;
import com.nasshb.pokerforge.pokersession.repository.PokerSessionRepository;
import com.nasshb.pokerforge.pokersession.service.PokerSessionService;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.repository.PokerUserRepository;
import com.nasshb.pokerforge.pokeruser.service.PokerUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PokerSessionTest {

    @Mock
    private PokerSessionRepository sessionRepository;

    @Mock
    private PokerUserRepository userRepository;

    @InjectMocks
    private PokerSessionService sessionService;

    @InjectMocks
    private PokerUserService userService;

    @Test
    void sessionSuccessfullyCreated(){
        //ARRANGE
        PokerUser user = new PokerUser(
                "Nassim",
                "Hb",
                "azerty",
                "nassim.hb@gmail.com"
        );
        user.setId(1);
        PokerSession session = new PokerSession(
                "Mini its time",
                5,
                25,
                user
        );
        when(userRepository.findById(1))
                .thenReturn(Optional.of(user));
        when(sessionRepository.save(any(PokerSession.class)))
                .thenReturn(session);

        //ACT
        PokerSessionResponse createdSession = sessionService.createSession("Mini its time", 5L, 25L, 1);

        //ASSERT
        assertThat(createdSession.getSessionName()).isEqualTo("Mini its time");
        assertThat(createdSession.getBuyIn()).isEqualTo(5);
        assertThat(createdSession.getWinnings()).isEqualTo(25);
        assertThat(createdSession.getUser()).isEqualTo(user);
        verify(userRepository).findById(1);
        verify(sessionRepository).save(any(PokerSession.class));
    }

    @Test
    void sessionFailedToCreate(){
        //ARRANGE
        when(userRepository.findById(999))
                .thenReturn(Optional.empty());

        //ARRANGE
        assertThrows(
                PokerUserNotFoundException.class,
                () -> sessionService.createSession("Mini its time", 5L, 25L, 999)
        );
    }

    @Test
    void retrieveASessionByHisIdSuccessfully(){
        //ARRANGE
        PokerUser user = new PokerUser(
                "Nassim",
                "Hb",
                "azerty",
                "nassim.hb@gmail.com"
        );
        user.setId(1);
        PokerSession session = new PokerSession(
                "Mini its time",
                5,
                25,
                user
        );
        session.setId(1L);
        when(sessionRepository.findById(1))
                .thenReturn(Optional.of(session));

        //ACT
        PokerSessionResponse sessionRetrieved = sessionService.getSessionById(1);

        //ASSERT
        assertThat(sessionRetrieved.getSessionName()).isEqualTo("Mini its time");
        assertThat(sessionRetrieved.getBuyIn()).isEqualTo(5);
        assertThat(sessionRetrieved.getWinnings()).isEqualTo(25);
        assertThat(sessionRetrieved.getUser().getId()).isEqualTo(1);
        assertThat(sessionRetrieved.getUser().getFirstName()).isEqualTo("Nassim");
        assertThat(sessionRetrieved.getUser().getLastName()).isEqualTo("Hb");


        verify(sessionRepository).findById(1);
    }

    @Test
    void retrieveASessionByHisIdFail(){
        //ARRANGE
        when(sessionRepository.findById(999))
                .thenReturn(Optional.empty());

        //ASSERT
        assertThrows(
             PokerSessionNotFoundException.class,
                () -> sessionService.getSessionById(999)
        );
        verify(sessionRepository).findById(999);
    }

    @Test
    void retrieveAllSessionsSuccessfully() {
        //ARRANGE
        PokerUser user = new PokerUser(
                "Nassim",
                "Hb",
                "azerty",
                "nassim.hb@gmail.com"
        );
        user.setId(1);
        PokerSession session = new PokerSession(
                "Mini its time",
                5,
                25,
                user
        );
        PokerSession session2 = new PokerSession(
                "Mini its time 2",
                5,
                100,
                user
        );
        session.setId(2L);
        List<PokerSession> sessions = List.of(session, session2);
        when(sessionRepository.findAll())
                .thenReturn(sessions);

        //ACT
        List<PokerSessionResponse> result = sessionService.getAllSessions();

        //ASSERT
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getSessionName())
                .isEqualTo("Mini its time");

        assertThat(result.get(1).getSessionName())
                .isEqualTo("Mini its time 2");
        verify(sessionRepository).findAll();
    }

    @Test
    void modifySessionSuccess(){
        //ARRANGE
        PokerUser user = new PokerUser(
                "Nassim",
                "Hb",
                "azerty",
                "nassim.hb@gmail.com"
        );
        user.setId(1);
        PokerSession session = new PokerSession(
                "Mini its time",
                5,
                25,
                user
        );
        session.setId(1L);
        when(sessionRepository.findById(1))
                .thenReturn(Optional.of(session));
        when(sessionRepository.save(any(PokerSession.class)))
                .thenReturn(session);

        //ACT
        PokerSessionResponse sessionModified = sessionService.modifySession(1, "Mini its time 2", 5L, 25L);

        //ASSERT
        assertThat(sessionModified.getSessionName()).isEqualTo("Mini its time 2");
        assertThat(sessionModified.getBuyIn()).isEqualTo(5);
        assertThat(sessionModified.getWinnings()).isEqualTo(25);
        verify(sessionRepository).findById(1);
        verify(sessionRepository).save(session);
    }

    @Test
    void sessionNotFoundForModifyIt(){
        //ARRANGE
        when(sessionRepository.findById(999))
                .thenReturn(Optional.empty());

        //ASSERT
        assertThrows(
                PokerSessionNotFoundException.class,
                () -> sessionService.modifySession(999, "Mini its time", 5L, 25L)
        );
        verify(sessionRepository).findById(999);
    }

    @Test
    void deleteSessionSuccess(){
        //ARRANGE
        PokerUser user = new PokerUser(
                "Nassim",
                "Hb",
                "azerty",
                "nassim.hb@gmail.com"
        );
        user.setId(1);
        PokerSession session = new PokerSession(
                "Mini its time",
                5,
                25,
                user
        );
        session.setId(1L);
        when(sessionRepository.findById(1))
                .thenReturn(Optional.of(session));

        //ACT
        sessionService.deleteSession(1);

        //ASSERT
        verify(sessionRepository).findById(1);
        verify(sessionRepository).delete(session);
    }

    @Test
    void sessionNotFoundForDeleteIt(){
        //ARRANGE
        when(sessionRepository.findById(999))
                .thenReturn(Optional.empty());

        //ASSERT
        assertThrows(
                PokerSessionNotFoundException.class,
                () -> sessionService.deleteSession(999)
        );
        verify(sessionRepository).findById(999);
    }
}
